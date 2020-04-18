package com.kelvindegrez.extensile.architecture.injector

import com.kelvindegrez.extensile.architecture.analytics.Logger
import com.kelvindegrez.extensile.architecture.database.Database
import com.kelvindegrez.extensile.architecture.network.Network
import com.kelvindegrez.extensile.architecture.coordinator.Coordinator

interface Injector {

    fun provideDatabase() : Database

    fun provideNetwork() : Network

    fun provideNavigationCoordinator(): Coordinator.NavigationCoordinator

    fun provideLogger(): Logger
}