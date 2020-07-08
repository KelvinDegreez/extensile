package com.kelvindegrez.extensile.mvi.android

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kelvindegrez.extensile.R
import com.kelvindegrez.extensile.architecture.ViewLoader

class FragmentViewLoader (
    private val fragmentManager: FragmentManager,
    private val fragmentContainerId: Int
) : ViewLoader<Fragment>() {

    override fun loadView(view: Fragment) {
        val ft = fragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(fragmentContainerId, view)
        ft.commit()
    }

    override fun removeView(view: Fragment) {
        val ft = fragmentManager.beginTransaction()
        ft.remove(view)
        ft.commit()
    }
}