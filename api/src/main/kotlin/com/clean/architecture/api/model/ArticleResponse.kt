package com.clean.architecture.api.model

data class ArticleResponse(
    val source: ArticleSourceResponse?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)