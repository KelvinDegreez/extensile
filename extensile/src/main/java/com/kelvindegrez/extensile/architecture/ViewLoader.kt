package com.kelvindegrez.extensile.architecture

import java.util.*

abstract class ViewLoader<V> {

    private val viewStack : Stack<V> = Stack()

    fun push(view: V) {
        viewStack.push(view)
        loadView(viewStack.peek())
    }

    fun pop() : Boolean {
        return when{
            viewStack.isEmpty() || viewStack.size == 1 -> false
            else -> {
                removeView(viewStack.peek())
                viewStack.pop()
                push(viewStack.peek())
                true
            }
        }
    }

    abstract fun loadView(view : V)

    abstract fun removeView(view : V)

}