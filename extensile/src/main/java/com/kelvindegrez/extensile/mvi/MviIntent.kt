package com.kelvindegrez.extensile.mvi

interface MviIntent<Action : MviIntent.Action> {

    val intentChannel: MviChannel<Action>

    interface Action

}