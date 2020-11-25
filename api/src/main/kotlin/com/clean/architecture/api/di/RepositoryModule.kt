package com.clean.architecture.api.di

import com.clean.architecture.api.news.NewsRepositoryImpl
import com.clean.architecture.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<NewsRepository> { NewsRepositoryImpl(get(), get()) }
}
