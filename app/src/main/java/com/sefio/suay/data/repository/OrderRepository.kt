package com.sefio.suay.data.repository

import com.sefio.suay.data.remote.OrderRemoteDataSource
import com.sefio.suay.domain.model.Order
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val userRepository: UserRepository,
    private val orderRemoteDataSource: OrderRemoteDataSource
){

    fun fetchUserOrders(): Response<List<Order>> {
        return try {
            val id = userRepository.loadIdentification()

            val response = orderRemoteDataSource.fetchUserOrders(id)

            if (response.isNotEmpty())
                Response.Success(response)
            else
                Response.EmptySuccess

        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}