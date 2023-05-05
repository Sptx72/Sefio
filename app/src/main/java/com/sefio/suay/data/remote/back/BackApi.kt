package com.sefio.suay.data.remote.back

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class BackApi @Inject constructor() : BasicApi{
    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://315e-5-225-110-122.ngrok-free.app")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)
}