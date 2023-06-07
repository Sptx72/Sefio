package com.sefio.suay.data.remote.api

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.ApiExecutor
import com.sefio.suay.data.remote.Endpoints
import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonObjectWrapper
import javax.inject.Inject

class UserApi @Inject constructor(
    private val apiExecutor: ApiExecutor
) {

    fun signIn(email:String, password:String): JsonObjectWrapper {
        val endpoint = Endpoints.LOGIN

        val body = JsonObject()
        body.addProperty(SefioParams.EMAIL, email)
        body.addProperty(SefioParams.PASSWORD, password)

        return apiExecutor.executePost(endpoint, body)
    }

}