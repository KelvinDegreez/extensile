package com.kelvindegrez.extensile.architecture.coordinator

interface Coordinator {

    fun start()

    fun onBack() : Boolean

    interface NavigationCoordinator : Coordinator

}