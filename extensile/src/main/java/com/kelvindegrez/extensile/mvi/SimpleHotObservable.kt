package com.kelvindegrez.extensile.mvi

class SimpleHotObservable<T>(initialValue : T) {

    private val subscriptions = mutableListOf<(T) -> Unit>()
    private var lastValue : T = initialValue

    fun subscribe(subscription : (T) -> Unit) {
        subscriptions.add(subscription)
    }

    fun send(value: T) {
        lastValue = value
        subscriptions.forEach{it.invoke(value)}}

    fun getValue() : T {return lastValue}

    fun dispose() {subscriptions.clear()}
}