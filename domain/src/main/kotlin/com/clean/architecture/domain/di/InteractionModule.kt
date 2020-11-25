package com.clean.architecture.domain.di

import com.clean.architecture.domain.usecase.NewsUseCase
import org.koin.dsl.module

val interactionModule = module {

    factory { NewsUseCase(get()) }
}