package com.sefio.suay.ui.screens.cart.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.sefio.suay.domain.model.Order

@Composable
fun OrdersList(
    orders: List<Order>
) {

    orders.map { 
        Text(text = it.product.name)
        Text(text = it.state.value)
    }

}