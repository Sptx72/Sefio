package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.ProductRepository
import javax.inject.Inject

class LoadProduct @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(pid:String) = productRepository.fetchProduct(pid)

}