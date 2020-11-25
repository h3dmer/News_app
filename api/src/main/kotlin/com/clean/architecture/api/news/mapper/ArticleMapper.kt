package com.clean.architecture.api.news.mapper

import com.clean.architecture.api.model.ArticleResponse
import com.clean.architecture.api.model.ArticleSourceResponse
import com.clean.architecture.core.formatters.DateFormat
import com.clean.architecture.domain.entity.model.news.Article
import com.clean.architecture.domain.entity.model.news.ArticleSource

class ArticleMapper {

    fun articleItemToDomainModel(article: ArticleResponse): Article {
        return article.run {
            Article(
                source = articleSourceToDomainModel(source),
                author = author ?: "",
                title = title ?: "",
                description = description ?: "",
                url = url ?: "",
                urlToImage = urlToImage ?: "",
                publishedAt = DateFormat.convertDateToPattern(publishedAt, "dd.MM.yyyy"),
                content = content ?: ""
            )
        }
    }

    private fun articleSourceToDomainModel(source: ArticleSourceResponse?): ArticleSource {
        return with(source) {
            ArticleSource(
                id = this?.id ?: "",
                name = this?.name ?: ""
            )
        }
    }
}