package com.clean.architecture.domain.entity.model

sealed class ResponseResult<out T> {

    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val error: Throwable) : ResponseResult<Nothing>()
    object Pending : ResponseResult<Nothing>()
    object Complete : ResponseResult<Nothing>()
}

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()
}