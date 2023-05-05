package com.sefio.suay.data.remote

import com.sefio.suay.data.remote.helpers.ProductApi
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.Product
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(
    private val productApi: ProductApi
) {

    suspend fun fetchRecommendedProducts(authToken: AuthToken): List<Product> {
        return productApi.fetchRecommendedProducts(authToken = authToken)
    }
}