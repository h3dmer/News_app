package com.clean.architecture.domain.entity.model.news

data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)