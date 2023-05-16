package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.ProductRepository
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class RecommendedProducts @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke() = Response.Failure<Exception>(Exception("unhandled"))
}