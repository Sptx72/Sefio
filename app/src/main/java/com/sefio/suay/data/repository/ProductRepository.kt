package com.sefio.suay.data.repository

import com.sefio.suay.data.remote.ProductRemoteDataSource
import com.sefio.suay.domain.model.Product
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val userRepository: UserRepository,
    private val productRemoteDataSource: ProductRemoteDataSource
) {

    fun fetchRecommendedProducts(): Response<List<Product>> {
        return try {
            val id = userRepository.loadIdentification()

            Response.Success(productRemoteDataSource.fetchRecommendedProducts(id))
        } catch (e:Exception) {
            Response.Failure(e)
        }
    }

    suspend fun fetchByCategory(id:Int): Response<List<Product>> {
        return try {

            val response = productRemoteDataSource.fetchByCategory(id)

            if (response.isNotEmpty())
                Response.Success(response)
            else
                Response.EmptySuccess

        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    suspend fun fetchProduct(pid: String): Response<Product> {
        return try {
            val response = productRemoteDataSource.fetchProduct(pid)

            Response.Success(response)
        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }

    }

}