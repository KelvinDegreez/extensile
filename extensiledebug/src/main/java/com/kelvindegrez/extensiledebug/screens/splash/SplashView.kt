package com.kelvindegrez.extensiledebug.screens.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelvindegrez.extensile.mvi.impl.MviViewFragment
import com.kelvindegrez.extensiledebug.R
import kotlinx.android.synthetic.main.debug_splash_layout.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashView : MviViewFragment<SplashModel.ViewState, SplashIntent.Action>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.debug_splash_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        debug_splash_button.setOnClickListener {
            GlobalScope.launch {
                intent.intentChannel.send(SplashIntent.Action.Test)
            }
        }
    }

    override fun render(viewState: SplashModel.ViewState) {
        if(viewState.test){
            debug_splash_constraintLayout.setBackgroundResource(R.color.colorAccent)
        }else{
            debug_splash_constraintLayout.setBackgroundResource(R.color.colorPrimary)
        }
    }

}