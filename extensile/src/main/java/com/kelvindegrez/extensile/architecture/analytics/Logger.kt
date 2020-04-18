package com.kelvindegrez.extensile.architecture.analytics

interface Logger {

    fun logWarning(tag: String, warning: String)

    fun logInfo(tag: String, info: String)

    fun logDebug(tag: String, message: String)

    fun logError(tag: String, error: Throwable)

    fun logError(tag: String, error: String)
}