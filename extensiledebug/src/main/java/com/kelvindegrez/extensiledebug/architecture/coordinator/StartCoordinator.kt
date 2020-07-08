package com.kelvindegrez.extensiledebug.architecture.coordinator

import com.kelvindegrez.extensile.architecture.coordinator.Coordinator
import com.kelvindegrez.extensiledebug.architecture.injector.ExtensileDebugInjector
import com.kelvindegrez.extensiledebug.screens.splash.SplashIntent
import com.kelvindegrez.extensiledebug.screens.splash.SplashModel
import com.kelvindegrez.extensiledebug.screens.splash.SplashView

class StartCoordinator : Coordinator {

    private val navigationCoordinator = ExtensileDebugInjector.provideNavigationCoordinator()
    private val viewLoader = navigationCoordinator.viewLoader

    override fun start() {
        showSplash()
    }

    fun showSplash() {
        val view = SplashView()
        view.setMvi(SplashModel(), SplashIntent())
        viewLoader.push(view)
    }

    override fun onBack(): Boolean {
        return false
    }

}