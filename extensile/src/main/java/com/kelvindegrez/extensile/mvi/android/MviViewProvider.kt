package com.kelvindegrez.extensile.mvi.android

import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.MviModel

abstract class MviViewProvider<VIEW_TYPE> {

    /**
     * Returns Triple<Model, View, Intent>
     */
    abstract fun <VIEW_STATE : MviModel.ViewState, ACTION : MviIntent.Action>
    provideView(viewState : VIEW_STATE, action: ACTION) : Triple<MviModel<VIEW_STATE, ACTION>, VIEW_TYPE, MviIntent<ACTION>>

}