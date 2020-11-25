package com.clean.architecture.core.initializers

import android.content.Context
import androidx.startup.Initializer
import com.facebook.stetho.Stetho

@Suppress("Unused")
class StethoInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        Stetho.initialize(
            Stetho.newInitializerBuilder(context)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                .build()
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}