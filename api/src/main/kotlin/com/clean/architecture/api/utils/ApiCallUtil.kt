package com.clean.architecture.api.utils

import com.clean.architecture.domain.entity.model.ResponseResult
import com.clean.architecture.domain.entity.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ApiCallUtil {

//    suspend fun <T : Any> safeApiCall(call: suspend () -> T): ResponseResult<T> {
//        return try {
//            val response = withContext(Dispatchers.IO) {
//                call()
//            }
//            ResponseResult.Success(response)
//        } catch (e: Exception) {
//            ResponseResult.Failure(e)
//        }
//    }

    suspend fun <T: Any> safeApiCall(
        call: suspend () -> Result<T>
    ): Result<T>{
        return try {
            call()
        }catch (e: Exception){
            Result.Failure(e)
        }
    }
}