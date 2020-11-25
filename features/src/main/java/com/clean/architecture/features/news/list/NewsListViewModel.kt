package com.clean.architecture.features.news.list

import androidx.lifecycle.*
import com.clean.architecture.core.utils.CoroutineContextProvider
import com.clean.architecture.domain.entity.model.Result
import com.clean.architecture.domain.usecase.NewsUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

internal class NewsListViewModel(
    private val newsListUseCase: NewsUseCase,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val _newsListState = MutableLiveData<NewsListState>(NewsListState())
    val newsListState: LiveData<NewsListState>
        get() = _newsListState

    init {
        onAction(NewsListUiAction.ScreenCreated)
    }

    fun onAction(uiAction: NewsListUiAction) {
        when (uiAction) {
            NewsListUiAction.ScreenCreated -> getNewsList()
        }
    }

    private fun getNewsList() {
        viewModelScope.launch {
            val result = withContext(contextProvider.IO) {
                newsListUseCase.getNews()
            }
            when (result) {
                is Result.Success -> _newsListState.postValue(
                    _newsListState.value?.copy(
                        newsList = result.data.articles,
                        isLoading = false
                    )
                )
                is Result.Failure -> {
                    Timber.e(result.error)
                    _newsListState.value =
                        _newsListState.value?.copy(apiError = result.error, isLoading = false)
                }
            }
        }
    }
}
