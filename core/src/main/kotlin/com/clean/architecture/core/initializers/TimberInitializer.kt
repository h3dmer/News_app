package com.clean.architecture.core.initializers

import android.content.Context
import androidx.startup.Initializer
import androidx.viewbinding.BuildConfig
import timber.log.Timber

@Suppress("Unused")
class TimberInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Timber initializer is initialized")
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
