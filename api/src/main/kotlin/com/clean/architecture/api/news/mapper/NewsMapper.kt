package com.clean.architecture.api.news.mapper

import com.clean.architecture.api.model.NewsResponse
import com.clean.architecture.domain.entity.model.news.News

class NewsMapper(
    private val articleMapper: ArticleMapper
) {

    fun mapNews(news: NewsResponse): News {
        return with(news) {
            News(
                status,
                totalResults,
                articles = articles.map { articleMapper.articleItemToDomainModel(it) }
            )
        }
    }
}
