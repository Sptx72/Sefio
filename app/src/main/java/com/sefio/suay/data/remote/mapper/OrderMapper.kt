package com.sefio.suay.data.remote.mapper

import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonArrayWrapper
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.Order
import com.sefio.suay.domain.model.OrderState
import javax.inject.Inject

class OrderMapper @Inject constructor(
    private val productMapper: ProductMapper
) {

    fun from(jsonObjectWrapper: JsonObjectWrapper): Order {
        return Order(
            id = jsonObjectWrapper.getInt(SefioParams.ID),
            state = OrderState.buildForCode(jsonObjectWrapper.getInt(SefioParams.STATE)),
            product = productMapper.from(jsonObjectWrapper.getJsonObjectWrapper(SefioParams.PRODUCT))
        )
    }

    fun from(jsonArrayWrapper: JsonArrayWrapper): List<Order> {
        return jsonArrayWrapper.getObjectArray().map {
            from(it)
        }
    }

}