package com.kelvindegrez.extensile.mvi

interface MviIntent<Action : MviIntent.Action> {

    val intentChannel: SimpleHotObservable<Action>

    interface Action

}