package com.kelvindegrez.extensile.mvi.impl

import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.mvi.MviIntent
import com.kelvindegrez.extensile.mvi.MviModel
import com.kelvindegrez.extensile.mvi.MviView

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
        intent.intentChannel.subscribe { model.handleAction(it) }
        model.viewStateChannel.subscribe { render(it) }
    }

    private fun setInactive() {
        intent.intentChannel.dispose()
        model.viewStateChannel.dispose()
//        model.compositeDisposable.dispose()
    }
}