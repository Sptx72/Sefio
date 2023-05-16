package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.ProductRepository
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class ProductsCategories @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(name:String) = Response.Failure<Exception>(Exception("unhandled"))
}