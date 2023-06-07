package com.sefio.suay.domain.model

sealed class ProductCategory(val id:Int, val value:String, val name:String) {
    object Recommended:ProductCategory(id = 0,value = "Recomendados", name = "recomendado")
    object Search:ProductCategory(id = 4,value = "Buscados", name = "buscado")
    object Clothes:ProductCategory(id = 2, value = "Ropa", name = "ropa")
    object Perfumery:ProductCategory(id = 3,value = "Perfumería", name = "perfumería")
    object Technology:ProductCategory(id = 1,value = "Tecnología", name = "tecnología")
}
