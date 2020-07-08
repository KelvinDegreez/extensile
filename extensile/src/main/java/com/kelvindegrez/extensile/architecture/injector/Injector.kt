package com.kelvindegrez.extensile.architecture.injector

import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.architecture.analytics.Logger
import com.kelvindegrez.extensile.architecture.database.Database
import com.kelvindegrez.extensile.architecture.network.Network
import com.kelvindegrez.extensile.architecture.coordinator.NavigationCoordinator

interface Injector {

    fun provideDatabase() : Database

    fun provideNetwork() : Network

    fun provideNavigationCoordinator(): NavigationCoordinator<Fragment>

    fun provideLogger(): Logger
}