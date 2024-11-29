package com.hj.average.core.data

import com.hj.average.core.network.NetworkResult

fun <T : Any, R : Any> NetworkResult<T>.asResult(mapper: (T) -> R): Result<R> =
    when (this) {
        is NetworkResult.Error -> Result.Error(this.code, this.message)
        is NetworkResult.Exception -> Result.Exception(this.e)
        is NetworkResult.Success -> Result.Success(mapper(this.data))
    }