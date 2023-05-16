package com.sefio.suay.data.remote

import com.google.gson.JsonObject
import com.sefio.suay.data.local.db.SefioDatabase
import com.sefio.suay.data.remote.back.Endpoints
import com.sefio.suay.data.remote.helpers.ApiRequestExecutor
import javax.inject.Inject

class AuthApi @Inject constructor(
    private val apiRequestExecutor: ApiRequestExecutor
) {

    fun signIn(email:String, password:String): String {
        val endpoint = Endpoints.SIGN_IN
        val body = JsonObject()
        body.addProperty("email", email)
        body.addProperty("password", password)
        val obj = apiRequestExecutor.executePostResponse(endpoint = endpoint, body = body)
        return obj.getString(SefioDashBoard.ID)
    }


}