package com.kelvindegrez.extensiledebug

import com.kelvindegrez.extensile.mvi.android.MviApplication
import com.kelvindegrez.extensiledebug.architecture.injector.ExtensileDebugInjector

class ExtensileDebugApplication : MviApplication() {

    override fun onCreate() {
        ExtensileDebugInjector.setApplicationContext(this)
        super.onCreate()

    }
}