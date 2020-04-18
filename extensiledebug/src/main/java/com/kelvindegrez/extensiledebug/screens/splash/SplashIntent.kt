package com.kelvindegrez.extensiledebug.screens.splash

import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.SimpleHotObservable

class SplashIntent : MviIntent<SplashIntent.Action> {

    override val intentChannel: SimpleHotObservable<Action> = SimpleHotObservable(Action.Test)

    sealed class Action : MviIntent.Action {
        object Test : Action()
    }

}