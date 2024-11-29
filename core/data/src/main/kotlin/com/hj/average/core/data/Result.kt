package com.hj.average.core.data

sealed class Result<out T> {
    class Success<T : Any>(val data: T) : Result<T>()
    class Error<T : Any>(val code: String, val message: String?) : Result<T>()
    class Exception<T : Any>(val throwable: Throwable) : Result<T>()
}