package com.kelvindegrez.extensiledebug.screens.splash

import com.kelvindegrez.extensile.mvi.MviIntent
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

class SplashIntent : MviIntent<SplashIntent.Action> {

    override val intentChannel= ConflatedBroadcastChannel<Action>(Action.Test)

    sealed class Action : MviIntent.Action {
        object Test : Action()
    }

}