package com.kelvindegrez.extensiledebug.screens.splash

import com.kelvindegrez.extensile.mvi.MviModel
import com.kelvindegrez.extensile.mvi.SimpleHotObservable
import com.kelvindegrez.extensile.mvi.android.AndroidMviModel


class SplashModel : AndroidMviModel<SplashModel.ViewState, SplashIntent.Action> {

    override val viewStateChannel: SimpleHotObservable<ViewState> = SimpleHotObservable(ViewState(false))

    override fun handleAction(action: SplashIntent.Action) {
        when(action){
            SplashIntent.Action.Test -> {
                viewStateChannel.send(viewStateChannel.getValue().copy(test = !viewStateChannel.getValue().test))
            }
        }
    }

    data class ViewState(
        val test: Boolean
    ): MviModel.ViewState

    override fun onBackPressed(): Boolean {
        return false
    }


}