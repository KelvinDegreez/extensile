package com.kelvindegrez.extensile.simpleReactive

class SimpleSingleValueObservable<T>
internal constructor(private val onSubscription : () -> T) {

    companion object {
        fun <T> create(onSubscription: () -> T) : SimpleSingleValueObservable<T> {
            return SimpleSingleValueObservable(onSubscription)
        }
    }

    fun subscribe(subscription : (T) -> Unit) {
        subscription.invoke(onSubscription.invoke())
    }
}