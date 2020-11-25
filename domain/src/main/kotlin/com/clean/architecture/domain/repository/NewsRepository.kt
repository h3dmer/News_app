package com.clean.architecture.domain.repository

import com.clean.architecture.domain.entity.model.Result
import com.clean.architecture.domain.entity.model.news.News

interface NewsRepository {

    suspend fun getEverything(): Result<News>
}