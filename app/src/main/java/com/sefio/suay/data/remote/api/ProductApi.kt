package com.sefio.suay.data.remote.api

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.ApiExecutor
import com.sefio.suay.data.remote.Endpoints
import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonArrayWrapper
import com.sefio.suay.domain.model.JsonObjectWrapper
import javax.inject.Inject

class ProductApi @Inject constructor(
    private val apiExecutor: ApiExecutor
) {

    fun fetchRecommendedProducts(id:String): JsonArrayWrapper {
        val endpoint = Endpoints.RECOMMENDED_PRODUCTS

        val body = JsonObject()
        body.addProperty(SefioParams.ID, id)

        return apiExecutor.executeArrayPost(endpoint = endpoint, body = body)
    }

    fun fetchByCategory(id:Int): JsonArrayWrapper {
        val endpoint = Endpoints.CATEGORY_PRODUCTS

        val body = JsonObject()
        body.addProperty(SefioParams.ID, id)

        return apiExecutor.executeArrayPost(endpoint = endpoint, body = body)
    }

    fun fetchProduct(pid: String): JsonObjectWrapper {
        val endpoint = Endpoints.PRODUCT

        val body = JsonObject()
        body.addProperty(SefioParams.ID, pid)

        return apiExecutor.executePost(endpoint = endpoint, body = body)
    }

}