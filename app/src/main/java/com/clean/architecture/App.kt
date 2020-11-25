package com.clean.architecture

import android.app.Application
import com.clean.architecture.api.di.mapperModule
import com.clean.architecture.api.di.networkModule
import com.clean.architecture.api.di.repositoryModule
import com.clean.architecture.core.di.coroutinesModule
import com.clean.architecture.features.di.presentationModule
import com.clean.architecture.domain.di.interactionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("Unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    presentationModule,
                    interactionModule,
                    mapperModule,
                    repositoryModule,
                    coroutinesModule,
                    networkModule
                )
            )
        }
    }
}
