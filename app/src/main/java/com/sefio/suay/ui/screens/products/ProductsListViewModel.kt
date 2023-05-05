package com.sefio.suay.ui.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.domain.model.Product
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.usecases.RecommendedProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val recommendedProducts: RecommendedProducts
) : ViewModel() {

    private val _recommendedProductsFlow = MutableStateFlow<Response<List<Product>>?>(null)
    val recommendedProductsFlow:StateFlow<Response<List<Product>>?> = _recommendedProductsFlow

    fun fetchRecommendedProducts() = viewModelScope.launch(Dispatchers.IO) {
        _recommendedProductsFlow.value = Response.Loading
        val result = recommendedProducts()
        _recommendedProductsFlow.value = result
    }

}