package com.kelvindegrez.extensiledebug.architecture.coordinator

import com.kelvindegrez.extensile.architecture.coordinator.Coordinator
import com.kelvindegrez.extensile.mvi.android.MviFragmentNavigationCoordinator
import com.kelvindegrez.extensile.mvi.android.MviFragmentViewActivity

class ExtensileDebugNavigationCoordinator(
    mviFragmentViewActivity: MviFragmentViewActivity
) : MviFragmentNavigationCoordinator(mviFragmentViewActivity) {

    override val launchCoordinator: Coordinator = SplashCoordinator(mviFragmentViewActivity)

}