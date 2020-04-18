package com.kelvindegrez.extensiledebug

import com.kelvindegrez.extensile.mvi.android.MviFragmentViewActivity
import com.kelvindegrez.extensiledebug.architecture.injector.ExtensileDebugInjector

class ExtensileMviFragmentViewActivity : MviFragmentViewActivity() {

    override fun onStart() {
        super.onStart()
        ExtensileDebugInjector.setMviFragmentActivityContext(this)
        navigationCoordinator = ExtensileDebugInjector.provideNavigationCoordinator()
        navigationCoordinator.start()
    }

}