package com.kelvindegrez.extensile.mvi.impl

import com.kelvindegrez.extensile.mvi.MviChannel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class ConflatedBroadcastMviChannel<E>(initialElement: E) : MviChannel<E> {

    private val channel = ConflatedBroadcastChannel(initialElement)
    
    override fun send(element: E) {
        GlobalScope.launch {
            channel.send(element)
            value = element
        }
    }

    override fun observe(observer: (E) -> Unit) {
        val subscription = channel.openSubscription()
        GlobalScope.launch {
            subscription.consumeEach {
                observer.invoke(it)
            }
        }
    }

    override fun close() {
        channel.close()
    }
    
    var value : E = initialElement
    private set

}