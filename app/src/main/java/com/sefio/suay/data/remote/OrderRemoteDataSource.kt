package com.sefio.suay.data.remote

import com.sefio.suay.data.remote.api.OrderApi
import com.sefio.suay.data.remote.mapper.OrderMapper
import com.sefio.suay.domain.model.Order
import javax.inject.Inject

class OrderRemoteDataSource @Inject constructor(
    private val orderApi: OrderApi,
    private val orderMapper: OrderMapper
) {

    fun fetchUserOrders(id:String): List<Order> {
        return orderMapper.from(orderApi.fetchUserOrders(id))
    }

}