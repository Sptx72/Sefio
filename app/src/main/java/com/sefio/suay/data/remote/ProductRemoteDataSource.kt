package com.sefio.suay.data.remote

import com.google.firebase.storage.StorageReference
import com.sefio.suay.data.remote.api.ProductApi
import com.sefio.suay.data.remote.mapper.ProductMapper
import com.sefio.suay.domain.model.Product
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(
    private val productApi: ProductApi,
    private val productMapper:ProductMapper,
    private val storageReference: StorageReference
) {

    fun fetchRecommendedProducts(id:String): List<Product> {
        return productMapper.from(productApi.fetchRecommendedProducts(id))
    }

    fun fetchByCategory(id: Int): List<Product> {
        return productMapper.from(productApi.fetchByCategory(id))
    }

    suspend fun fetchProduct(pid: String): Product {
        return productMapper.from(productApi.fetchProduct(pid), loadImage(pid))
    }

    suspend fun loadImage(pid:String):String {
        val image = storageReference.child("$pid/main.jpg").downloadUrl
        image.await()
        return image.result.toString()
    }

}