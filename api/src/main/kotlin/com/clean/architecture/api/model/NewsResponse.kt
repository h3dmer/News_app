package com.clean.architecture.api.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleResponse>
)