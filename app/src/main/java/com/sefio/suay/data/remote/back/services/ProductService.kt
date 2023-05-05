package com.sefio.suay.data.remote.back.services

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.back.Endpoints
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HTTP

interface ProductService {

    @HTTP(method = "POST", path = Endpoints.RECOMMENDED_PRODUCTS)
    fun fetchRecommendedProducts(@Body body:JsonObject): Call<JsonObject>
}