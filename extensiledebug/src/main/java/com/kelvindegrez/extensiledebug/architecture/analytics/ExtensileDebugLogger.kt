package com.kelvindegrez.extensiledebug.architecture.analytics

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.kelvindegrez.extensile.architecture.analytics.Logger

class ExtensileDebugLogger(private val context: Context) : Logger {

    override fun logWarning(tag: String, warning: String) {
        Log.w(tag, warning)
    }

    override fun logInfo(tag: String, info: String) {
        Log.i(tag, info)
    }

    override fun logDebug(tag: String, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        Log.d(tag, message)
    }

    override fun logError(tag: String, error: Throwable) {
        Log.e(tag, Log.getStackTraceString(error))
    }

    override fun logError(tag: String, error: String) {
        Log.e(tag, error)
    }

}