package com.kelvindegrez.extensiledebug

import com.kelvindegrez.extensile.mvi.android.ExtensileApplication
import com.kelvindegrez.extensiledebug.architecture.injector.ExtensileDebugInjector

class ExtensileDebugApplication : ExtensileApplication() {

    override fun onCreate() {
        ExtensileDebugInjector.setApplicationContext(this)
        super.onCreate()
    }
}