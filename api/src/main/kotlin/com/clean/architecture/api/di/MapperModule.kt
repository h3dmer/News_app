package com.clean.architecture.api.di

import com.clean.architecture.api.news.mapper.ArticleMapper
import com.clean.architecture.api.news.mapper.NewsMapper
import org.koin.dsl.module

val mapperModule = module {

    factory { NewsMapper(get()) }
    factory { ArticleMapper() }
}