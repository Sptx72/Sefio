package com.sefio.suay.data.remote.api

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.ApiExecutor
import com.sefio.suay.data.remote.Endpoints
import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonArrayWrapper
import javax.inject.Inject

class OrderApi @Inject constructor(
    private val apiExecutor: ApiExecutor
) {

    fun fetchUserOrders(id:String): JsonArrayWrapper {
        val endpoint = Endpoints.USER_ORDERS

        val body = JsonObject()
        body.addProperty(SefioParams.ID, id)

        return apiExecutor.executeArrayPost(endpoint = endpoint, body = body)
    }

}