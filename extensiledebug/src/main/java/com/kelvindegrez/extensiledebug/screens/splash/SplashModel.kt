package com.kelvindegrez.extensiledebug.screens.splash

import com.kelvindegrez.extensile.mvi.MviModel
import com.kelvindegrez.extensile.mvi.android.AndroidMviModel
import com.kelvindegrez.extensile.mvi.impl.ConflatedBroadcastMviChannel

class SplashModel : AndroidMviModel<SplashModel.ViewState, SplashIntent.Action> {

    override val viewStateChannel = ConflatedBroadcastMviChannel(ViewState(false))

    override fun handleAction(action: SplashIntent.Action) {
        when(action){
            SplashIntent.Action.Test -> {
                viewStateChannel.send(viewStateChannel.value.copy(test = !viewStateChannel.value.test))
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