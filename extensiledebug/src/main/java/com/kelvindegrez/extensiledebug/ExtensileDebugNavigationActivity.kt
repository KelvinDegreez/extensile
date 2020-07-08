package com.kelvindegrez.extensiledebug

import com.kelvindegrez.extensile.mvi.android.ExtensileFragmentActivity
import com.kelvindegrez.extensiledebug.architecture.injector.ExtensileDebugInjector

class ExtensileDebugNavigationActivity : ExtensileFragmentActivity() {

    override val navigationCoordinator = ExtensileDebugInjector.provideNavigationCoordinator()

}