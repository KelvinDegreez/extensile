package com.kelvindegrez.extensile.mvi

interface MviChannel<E> {

    fun send(element: E)

    fun observe(observer : (E) -> Unit)

    fun close()
}