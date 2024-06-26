package com.sefio.suay.data.remote.api

import retrofit2.Retrofit

interface BasicApi {
    val retrofit:Retrofit

    fun <T> create(service: Class<T>): T
}