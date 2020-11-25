package com.clean.architecture.domain.usecase

import com.clean.architecture.domain.repository.NewsRepository

class NewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun getNews() = newsRepository.getEverything()
}