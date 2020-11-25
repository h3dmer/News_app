package com.clean.architecture.core.utils

import androidx.lifecycle.liveData
import com.clean.architecture.domain.entity.model.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

inline fun <T> liveResponse(coroutineContextProvider: CoroutineContextProvider, crossinline body: suspend () -> ResponseResult<T>) =
    liveData(coroutineContextProvider.IO) {
        emit(ResponseResult.Pending)
        val result = body()
        emit(result)
        emit(ResponseResult.Complete)
    }
