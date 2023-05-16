package com.sefio.suay.domain.model

sealed class ProductCategory(val value:String, val name:String) {
    object Recommended:ProductCategory(value = "Recomendados", name = "recomendado")
    object Search:ProductCategory(value = "buscados", name = "buscado")
    object Clothes:ProductCategory(value = "Ropa", name = "ropa")
    object Perfumery:ProductCategory(value = "Perfumería", name = "perfumería")
    object Technology:ProductCategory(value = "Tecnología", name = "tecnología")
}
