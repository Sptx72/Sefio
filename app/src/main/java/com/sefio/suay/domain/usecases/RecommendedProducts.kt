package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.ProductRepository
import javax.inject.Inject

class RecommendedProducts @Inject constructor(
    private val productRepository: ProductRepository
) {

    operator fun invoke() = productRepository.fetchRecommendedProducts()

}