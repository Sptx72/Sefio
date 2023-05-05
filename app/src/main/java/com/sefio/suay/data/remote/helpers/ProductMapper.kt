package com.sefio.suay.data.remote.helpers

import com.sefio.suay.data.remote.SefioDashBoard
import com.sefio.suay.domain.model.JsonArrayWrapper
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() {

    fun from(jsonArrayWrapper: JsonArrayWrapper): List<Product> {
        return jsonArrayWrapper.jsonArray.map { from(JsonObjectWrapper(it.asJsonObject)) }
    }

    fun from(jsonObjectWrapper: JsonObjectWrapper): Product {
        return Product(
            id = jsonObjectWrapper.getString(SefioDashBoard.ID),
            name = jsonObjectWrapper.getString(SefioDashBoard.NAME),
            description = jsonObjectWrapper.optString(SefioDashBoard.DESCRIPTION),
            price = jsonObjectWrapper.getDouble(SefioDashBoard.PRICE),
            category = listOf(),
            stars = 3.0
        )
    }
}