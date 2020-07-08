package com.kelvindegrez.extensiledebug.architecture.coordinator

import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.architecture.coordinator.NavigationCoordinator

class ExtensileDebugNavigationCoordinator : NavigationCoordinator<Fragment>() {

    override val launchCoordinator : StartCoordinator by lazy { StartCoordinator()}

    fun showHome() {

    }

}