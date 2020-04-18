package com.kelvindegrez.extensile.mvi.android

import com.kelvindegrez.extensile.architecture.coordinator.Coordinator
import java.util.*

abstract class MviFragmentNavigationCoordinator(
    mviFragmentViewActivity: MviFragmentViewActivity
) : MviFragmentCoordinator(mviFragmentViewActivity) {

    abstract val launchCoordinator : Coordinator
    private val coordinatorStack : Stack<Coordinator> = Stack()

    override fun start() {
        if(coordinatorStack.isEmpty()) coordinatorStack.push(launchCoordinator)
        coordinatorStack.peek().start()
    }

    override fun onBack(): Boolean {
        return if(coordinatorStack.isEmpty()) {
            false
        }else{
            if(!coordinatorStack.peek().onBack()) coordinatorStack.pop()
            if(coordinatorStack.isEmpty()) {
                false
            }else{
                coordinatorStack.peek().start()
                true
            }
        }
    }
}