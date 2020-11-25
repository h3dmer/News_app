package com.clean.architecture.features.di

import com.clean.architecture.features.news.list.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { NewsListViewModel(get(), get()) }
}