package com.sefio.suay.data.remote.mapper

import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonArrayWrapper
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() {

    fun from(jsonObjectWrapper: JsonObjectWrapper):Product {
        return from(jsonObjectWrapper, "")
    }

    fun from(jsonObjectWrapper: JsonObjectWrapper, imageRef:String): Product {
        return Product(
            id = jsonObjectWrapper.getString(SefioParams.ID),
            name = jsonObjectWrapper.getString(SefioParams.NAME),
            description = jsonObjectWrapper.getString(SefioParams.DESCRIPTION),
            stars = jsonObjectWrapper.getDouble(SefioParams.STARS),
            price = jsonObjectWrapper.optDouble(SefioParams.PRICE),
            brand = jsonObjectWrapper.getString(SefioParams.BRAND),
            discount = jsonObjectWrapper.getInt(SefioParams.DISCOUNT),
            imageRef = imageRef
        )
    }

    fun from(jsonArrayWrapper: JsonArrayWrapper): List<Product> {
        return jsonArrayWrapper.getObjectArray().map {
            from(it)
        }
    }

}