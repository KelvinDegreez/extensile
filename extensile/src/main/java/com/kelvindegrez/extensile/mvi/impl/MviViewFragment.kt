package com.kelvindegrez.extensile.mvi.impl

import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.MviModel
import com.kelvindegrez.extensile.mvi.MviView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class MviViewFragment<ViewState : MviModel.ViewState, Action : MviIntent.Action> : Fragment(), MviView<ViewState> {

    private lateinit var model : MviModel<ViewState, Action>
    lateinit var intent : MviIntent<Action>

    fun setMvi(model : MviModel<ViewState, Action>, intent : MviIntent<Action>) : MviViewFragment<ViewState, Action>{
        this.model = model
        this.intent = intent
        return this
    }

    override fun onStart() {
        super.onStart()
        setActive()
    }

    override fun onStop() {
        super.onStop()
        setInactive()
    }

    private fun setActive() {
        val intentChannel = intent.intentChannel.openSubscription()
        val modelChannel = model.viewStateChannel.openSubscription()
        GlobalScope.launch {
            intentChannel.consumeEach {
                model.handleAction(it)
            }
        }
        GlobalScope.launch {
            modelChannel.consumeEach {
                render(it)
            }
        }
    }

    private fun setInactive() {
        intent.intentChannel.cancel()
        model.viewStateChannel.cancel()
    }
}