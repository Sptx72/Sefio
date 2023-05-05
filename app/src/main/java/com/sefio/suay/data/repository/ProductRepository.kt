package com.sefio.suay.data.repository

import com.sefio.suay.data.remote.ProductRemoteDataSource
import com.sefio.suay.domain.model.Product
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val authRepository: AuthRepository,
    private val productRemoteDataSource: ProductRemoteDataSource
) {

    suspend fun fetchRecommendedProducts(): Response<List<Product>> {
        return try {
            val authToken = authRepository.fetchAuthToken()
            val products = productRemoteDataSource.fetchRecommendedProducts(authToken = authToken)

            Response.Success(products)
        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}