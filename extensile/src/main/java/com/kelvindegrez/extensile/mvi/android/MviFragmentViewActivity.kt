package com.kelvindegrez.extensile.mvi.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.R
import com.kelvindegrez.extensile.architecture.coordinator.Coordinator

abstract class MviFragmentViewActivity : AppCompatActivity() {

    private val fragmentContainerId : Int = R.id.mvi_fragment_view_activity_container
    lateinit var navigationCoordinator : Coordinator.NavigationCoordinator
    lateinit var viewProvider : MviViewProvider<Fragment>

    override fun onStart() {
        super.onStart()
        if(application !is MviApplication){
            throw Exception("Application is not an instance of MviApplication")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.extensile_mvi_fragment_view_activity_layout)
    }

    override fun onBackPressed() {
        if(!navigationCoordinator.onBack()) this.finish()
    }

    fun loadView(fragment : Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(fragmentContainerId, fragment)
        ft.commit()
    }

    fun removeView(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.remove(fragment)
        ft.commit()
    }
}
