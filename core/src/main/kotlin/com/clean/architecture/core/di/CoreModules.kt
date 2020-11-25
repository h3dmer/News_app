package com.clean.architecture.core.di

import com.clean.architecture.core.utils.CoroutineContextProvider
import org.koin.dsl.module

val coroutinesModule = module {
    factory { CoroutineContextProvider() }
}