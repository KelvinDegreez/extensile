package com.kelvindegrez.extensile.architecture.coordinator

import com.kelvindegrez.extensile.architecture.ViewLoader
import java.util.*


abstract class NavigationCoordinator<VIEW_TYPE> : Coordinator {

    abstract val launchCoordinator : Coordinator
    private val coordinatorStack : Stack<Coordinator> = Stack()
    lateinit var viewLoader : ViewLoader<VIEW_TYPE>

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

    fun push(coordinator: Coordinator) {
        coordinatorStack.push(coordinator)
        coordinatorStack.peek().start()
    }

}

