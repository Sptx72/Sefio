package com.sefio.suay.domain.model

data class Product(
    val id:String,
    val name:String,
    val description:String?,
    val price:Double?,
    val stars:Double,
    val brand:String,
    val discount:Int,
    var imageRef:String = ""
)