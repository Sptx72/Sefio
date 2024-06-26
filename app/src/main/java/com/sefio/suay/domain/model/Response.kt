package com.sefio.suay.domain.model

sealed class Response <out T> {
    object Loading: Response<Nothing>()
    object EmptySuccess: Response<Nothing>()

    data class Success<out T>(val data: T): Response<T>()
    data class Failure<out T>(val e:Exception): Response<T>()
}
