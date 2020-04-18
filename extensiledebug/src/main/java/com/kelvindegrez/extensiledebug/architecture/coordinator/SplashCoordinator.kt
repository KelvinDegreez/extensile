package com.kelvindegrez.extensiledebug.architecture.coordinator

import com.kelvindegrez.extensile.mvi.android.MviFragmentCoordinator
import com.kelvindegrez.extensile.mvi.android.MviFragmentViewActivity
import com.kelvindegrez.extensiledebug.screens.splash.SplashIntent
import com.kelvindegrez.extensiledebug.screens.splash.SplashModel
import com.kelvindegrez.extensiledebug.screens.splash.SplashView

class SplashCoordinator(mviFragmentViewActivity: MviFragmentViewActivity) : MviFragmentCoordinator(mviFragmentViewActivity) {

    override fun start() {
        val splashModel = SplashModel()
        val splashIntent = SplashIntent()
        val splashView = SplashView()
        splashView.setMvi(splashModel, splashIntent)
        push(splashView)
    }

}