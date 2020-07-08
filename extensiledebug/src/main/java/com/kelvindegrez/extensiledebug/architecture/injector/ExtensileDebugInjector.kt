package com.kelvindegrez.extensiledebug.architecture.injector

import android.app.Application
import androidx.fragment.app.Fragment
import com.kelvindegrez.extensile.architecture.analytics.Logger
import com.kelvindegrez.extensile.architecture.coordinator.NavigationCoordinator
import com.kelvindegrez.extensile.architecture.injector.Injector
import com.kelvindegrez.extensiledebug.architecture.analytics.ExtensileDebugLogger
import com.kelvindegrez.extensiledebug.architecture.coordinator.ExtensileDebugNavigationCoordinator
import com.kelvindegrez.extensiledebug.architecture.database.ExtensileDebugDatabase
import com.kelvindegrez.extensiledebug.architecture.network.ExtensileDebugNetwork
import java.lang.ref.WeakReference

object ExtensileDebugInjector : Injector {

    private val TAG = javaClass.name

    private var context: WeakReference<Application>? = null
    private val contextNotSetException = Exception("Application context has not been set. Please set context via setApplicationContext(application: Application)")
    private val contextReferenceLostException = Exception("Application context was set, however the reference has been lost")
    fun setApplicationContext(application: Application) {context = WeakReference(application)}

    private val database : ExtensileDebugDatabase by lazy { ExtensileDebugDatabase() }
    private val network : ExtensileDebugNetwork by lazy { ExtensileDebugNetwork() }
    private val logger : ExtensileDebugLogger by lazy {
        when {
            context == null -> throw contextNotSetException
            context!!.get() == null -> throw contextReferenceLostException
            else -> ExtensileDebugLogger(context!!.get()!!)
        }
    }
    private val coordinator : NavigationCoordinator<Fragment> by lazy { ExtensileDebugNavigationCoordinator() }

    override fun provideDatabase(): ExtensileDebugDatabase = database

    override fun provideNetwork(): ExtensileDebugNetwork = network

    override fun provideNavigationCoordinator(): NavigationCoordinator<Fragment> = coordinator

    override fun provideLogger(): Logger = logger

}

