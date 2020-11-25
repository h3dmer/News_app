package com.clean.architecture.api.di

import com.clean.architecture.api.interceptors.NewsApiInterceptor
import com.clean.architecture.api.news.NewsService
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideNewsApiInterceptor() }
    factory { provideOkHttpClient(get(), get()) }
    factory { provideNewsApi(get()) }
    single { provideRetrofit(get()) }
}

private fun provideNewsApi(retrofit: Retrofit): NewsService =
    retrofit.create(NewsService::class.java)

private fun provideNewsApiInterceptor(): NewsApiInterceptor = NewsApiInterceptor()

private fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun provideOkHttpClient(
    newsApiInterceptor: NewsApiInterceptor,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
        .addInterceptor(loggingInterceptor)
        .addInterceptor(newsApiInterceptor)
        .build()

}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://newsapi.org/v2/")
        .build()
}
