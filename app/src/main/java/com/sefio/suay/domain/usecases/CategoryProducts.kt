package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.ProductRepository
import javax.inject.Inject

class CategoryProducts @Inject constructor(
    private val productRepository: ProductRepository
){

    suspend operator fun invoke(id:Int) = productRepository.fetchByCategory(id)

}