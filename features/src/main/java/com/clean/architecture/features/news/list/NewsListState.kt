package com.clean.architecture.features.news.list

import com.clean.architecture.domain.entity.model.news.Article

data class NewsListState(
    val newsList: List<Article> = emptyList(),
    val isLoading: Boolean = true,
    val apiError: Throwable? = null
)
