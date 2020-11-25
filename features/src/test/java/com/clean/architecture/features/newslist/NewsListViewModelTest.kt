package com.clean.architecture.features.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.clean.architecture.domain.entity.model.Result
import com.clean.architecture.domain.entity.model.news.Article
import com.clean.architecture.domain.entity.model.news.ArticleSource
import com.clean.architecture.domain.entity.model.news.News
import com.clean.architecture.domain.usecase.NewsUseCase
import com.clean.architecture.features.news.list.NewsListState
import com.clean.architecture.features.news.list.NewsListUiAction
import com.clean.architecture.features.news.list.NewsListViewModel
import com.clean.architecture.features.utils.CoroutineRule
import com.clean.architecture.features.utils.TestContextProvider
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class NewsListViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = CoroutineRule()

    private val news = News("", 10, articles)

    private val newsUseCase = mock<NewsUseCase>()

    private val stateObserver = mock<Observer<NewsListState>>()

    private lateinit var newsListViewModel: NewsListViewModel

    @Before
    fun setUp() {
        newsListViewModel = NewsListViewModel(newsUseCase, TestContextProvider())
        newsListViewModel.newsListState.observeForever(stateObserver)
    }

    @Test
    fun `should get news after screen created`() = coroutineRule.runBlockingTest {
        // given
        whenever(newsUseCase.getNews()).thenReturn(Result.Success(news))

        // when
        newsListViewModel.onAction(NewsListUiAction.ScreenCreated)

        // then
        stateObserver.inOrder {
            verify().onChanged(NewsListState(newsList = articles, isLoading = false))
        }
    }

    @Test
    fun `should return error after fail`() = coroutineRule.runBlockingTest {
        // given
        val error = Throwable()
        whenever(newsUseCase.getNews()).thenReturn(Result.Failure(error))

        // when
        newsListViewModel.onAction(NewsListUiAction.ScreenCreated)

        // then
        stateObserver.inOrder {
            verify().onChanged(NewsListState(isLoading = false, apiError = error))
        }
    }

    companion object {
        val articles = listOf(
            Article(
                ArticleSource("1", "test"),
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
            )
        )
    }
}
