package com.sefio.suay.data.remote.back.services

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.data.remote.back.Endpoints
import retrofit2.Call
import retrofit2.http.HTTP
import retrofit2.http.Path

interface AuthService {

    @HTTP(method = "GET", path = Endpoints.SIGN_IN)
    fun signIn(@Path(SefioParams.EMAIL) email:String, @Path(SefioParams.PASSWORD) password:String): Call<JsonObject>
}