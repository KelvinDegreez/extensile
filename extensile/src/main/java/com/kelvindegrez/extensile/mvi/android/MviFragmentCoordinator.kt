package com.kelvindegrez.extensile.mvi.android

import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.architecture.coordinator.Coordinator
import java.util.*

abstract class MviFragmentCoordinator(
    private val mviFragmentViewActivity: MviFragmentViewActivity
) : Coordinator.NavigationCoordinator {

    private val fragmentStack : Stack<Fragment> = Stack()

    protected fun push(fragment: Fragment) {
        fragmentStack.push(fragment)
        mviFragmentViewActivity.loadView(fragmentStack.peek())
    }

    protected fun pop() {
        if(fragmentStack.isNotEmpty()){
            val currentFragment = fragmentStack.peek()
            mviFragmentViewActivity.removeView(currentFragment)
            fragmentStack.pop()
        }
        if(fragmentStack.isNotEmpty()) {
            val previousFragment = fragmentStack.peek()
            push(previousFragment)
        }
        mviFragmentViewActivity.loadView(fragmentStack.peek())
    }

    override fun onBack(): Boolean {
        return if(fragmentStack.isNotEmpty()){
            pop()
            true
        } else {
            false
        }
    }
}