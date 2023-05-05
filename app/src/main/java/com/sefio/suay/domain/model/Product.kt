package com.sefio.suay.domain.model

import android.graphics.Bitmap

data class Product(
    val id:String,
    val name:String,
    val description:String?,
    val price:Double,
    val category:List<String>,
    val stars:Double,
)