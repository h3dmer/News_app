package com.clean.architecture.api.news

import com.clean.architecture.api.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getNews(@Query("q") query: String): NewsResponse
}
