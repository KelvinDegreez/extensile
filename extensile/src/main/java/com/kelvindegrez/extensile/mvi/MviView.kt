package com.kelvindegrez.extensile.mvi

interface MviView<ViewState : MviModel.ViewState> {

    fun render(viewState : ViewState)

}