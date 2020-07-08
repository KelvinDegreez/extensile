package com.kelvindegrez.extensile.mvi

import kotlinx.coroutines.channels.BroadcastChannel


interface MviModel<ViewState : MviModel.ViewState, Action : MviIntent.Action> {

    val viewStateChannel: BroadcastChannel<ViewState>

    fun handleAction(action : Action)

    interface ViewState

}