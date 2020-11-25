package com.clean.architecture.api.news

import com.clean.architecture.api.news.mapper.NewsMapper
import com.clean.architecture.api.utils.ApiCallUtil
import com.clean.architecture.api.utils.ApiCallUtil.safeApiCall
import com.clean.architecture.domain.entity.model.Result
import com.clean.architecture.domain.entity.model.news.News
import com.clean.architecture.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsService: NewsService,
    private val mapper: NewsMapper
) : NewsRepository {

    override suspend fun getEverything(): Result<News> {
        return safeApiCall {
            Result.Success(mapper.mapNews(newsService.getNews("covid")))
        }
    }
}
