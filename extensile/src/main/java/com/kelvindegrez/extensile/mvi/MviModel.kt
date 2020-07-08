package com.kelvindegrez.extensile.mvi

interface MviModel<ViewState : MviModel.ViewState, Action : MviIntent.Action> {

    val viewStateChannel: MviChannel<ViewState>

    fun handleAction(action : Action)

    interface ViewState

}