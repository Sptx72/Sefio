package com.sefio.suay.domain.model

data class Order(
    val id:Int,
    val state:OrderState,
    val product: Product
)
