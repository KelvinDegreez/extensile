package com.kelvindegrez.extensile.mvi.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.R
import com.kelvindegrez.extensile.architecture.coordinator.NavigationCoordinator

abstract class ExtensileFragmentActivity : AppCompatActivity() {

    private val fragmentContainerId : Int = R.id.mvi_fragment_view_activity_container
    abstract val navigationCoordinator : NavigationCoordinator<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.extensile_fragment_view_activity_layout)
        navigationCoordinator.viewLoader = FragmentViewLoader(supportFragmentManager, fragmentContainerId)
    }

    override fun onStart() {
        super.onStart()
        if(application !is ExtensileApplication){
             throw Exception("Application is not an instance of ExtensileApplication")
        }
        navigationCoordinator.start()
    }

    override fun onBackPressed() {
        if(!navigationCoordinator.onBack()){
            finishAffinity()
            finish()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

}
