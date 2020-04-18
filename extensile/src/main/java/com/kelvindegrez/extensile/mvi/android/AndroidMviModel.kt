package com.kelvindegrez.extensile.mvi.android

import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.MviModel

interface AndroidMviModel<ViewState : MviModel.ViewState, Action : MviIntent.Action> : MviModel<ViewState, Action> {

    fun onBackPressed() : Boolean
}