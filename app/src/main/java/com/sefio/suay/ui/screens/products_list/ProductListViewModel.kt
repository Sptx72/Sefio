package com.sefio.suay.ui.screens.products_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.domain.model.Product
import com.sefio.suay.domain.model.ProductCategory
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.usecases.ProductsByCategory
import com.sefio.suay.domain.usecases.ProductsByData
import com.sefio.suay.domain.usecases.ProductsCategories
import com.sefio.suay.domain.usecases.RecommendedProducts
import com.sefio.suay.helpers.AppTextUtils
import com.sefio.suay.ui.screens.products_list.components.ProductNameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val recommendedProducts: RecommendedProducts,
    private val productsCategories: ProductsCategories,
    private val productsByData: ProductsByData,
    private val productsByCategory: ProductsByCategory
): ViewModel() {

    var state by mutableStateOf(ProductNameState())
        private set
    var namesResponse by mutableStateOf<Response<List<String>>?>(null)
    var productsResponse by mutableStateOf<Response<List<Product>>?>(null)

    var productsCategory by mutableStateOf<ProductCategory>(ProductCategory.Recommended)

    fun onNameInput(name:String) {
        state = state.copy(name = name)
    }

    fun fetchProductsName() = viewModelScope.launch(Dispatchers.IO) {

    }

    fun fetchRecommendedProducts() = viewModelScope.launch(Dispatchers.IO) {

    }

    fun fetchProductsByName(name:String) = viewModelScope.launch(Dispatchers.IO) {

    }

    fun fetchProductsByCategory(receivedCategory:ProductCategory) = viewModelScope.launch(Dispatchers.IO) {

    }
}