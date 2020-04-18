package com.kelvindegrez.extensiledebug.architecture.injector

import android.app.Application
import com.kelvindegrez.extensile.architecture.analytics.Logger
import com.kelvindegrez.extensile.architecture.injector.Injector
import com.kelvindegrez.extensile.mvi.android.MviFragmentViewActivity
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

    private var mviFragmentActivity: WeakReference<MviFragmentViewActivity>? = null
    private val mviFragmentActivityNotSetException = Exception("MviFragment context has not been set. Please set context via setMviFragmentActivityContext(mviFragmentViewActivity: MviFragmentViewActivity)")
    private val mviFragmentActivityReferenceLostException = Exception("MviFragment context was set, however the reference has been lost")
    fun setMviFragmentActivityContext(mviFragmentViewActivity: MviFragmentViewActivity) {mviFragmentActivity = WeakReference(mviFragmentViewActivity)}

    private val database : ExtensileDebugDatabase by lazy { ExtensileDebugDatabase() }
    private val network : ExtensileDebugNetwork by lazy { ExtensileDebugNetwork() }
    private val logger : ExtensileDebugLogger by lazy {
        when {
            context == null -> throw contextNotSetException
            context!!.get() == null -> throw contextReferenceLostException
            else -> ExtensileDebugLogger(context!!.get()!!)
        }
    }
    private val coordinator : ExtensileDebugNavigationCoordinator by lazy {
        when {
            mviFragmentActivity == null -> throw mviFragmentActivityNotSetException
            mviFragmentActivity!!.get() == null -> throw mviFragmentActivityReferenceLostException
            else -> ExtensileDebugNavigationCoordinator(mviFragmentActivity!!.get()!!)
        }
    }

    override fun provideDatabase(): ExtensileDebugDatabase = database

    override fun provideNetwork(): ExtensileDebugNetwork = network

    override fun provideNavigationCoordinator(): ExtensileDebugNavigationCoordinator = coordinator

    override fun provideLogger(): Logger = logger
}