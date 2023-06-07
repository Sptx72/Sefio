package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.OrderRepository
import javax.inject.Inject

class UserOrders @Inject constructor(
    private val orderRepository: OrderRepository
) {

    operator fun  invoke() = orderRepository.fetchUserOrders()

}