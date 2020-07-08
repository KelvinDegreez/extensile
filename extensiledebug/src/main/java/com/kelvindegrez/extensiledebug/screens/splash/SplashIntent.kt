package com.kelvindegrez.extensiledebug.screens.splash

import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.impl.ConflatedBroadcastMviChannel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

class SplashIntent : MviIntent<SplashIntent.Action> {

    override val intentChannel = ConflatedBroadcastMviChannel<Action>(Action.Test)

    sealed class Action : MviIntent.Action {
        object Test : Action()
    }

}