package com.kelvindegrez.extensile.mvi

import kotlinx.coroutines.channels.BroadcastChannel

interface MviIntent<Action : MviIntent.Action> {

    val intentChannel: BroadcastChannel<Action>

    interface Action

}