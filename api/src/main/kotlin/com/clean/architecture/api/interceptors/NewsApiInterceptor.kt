package com.clean.architecture.api.interceptors

import com.clean.architecture.api.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NewsApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Api-Key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(request)
    }
}
