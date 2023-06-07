package com.sefio.suay.ui.screens.product_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import com.sefio.suay.domain.model.Product
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.usecases.LoadProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
private val loadProduct: LoadProduct
): ViewModel() {

    var productResponse by mutableStateOf<Response<Product>?>(null)
        private set

    fun fetchProduct(pid:String) = viewModelScope.launch(Dispatchers.IO) {
        productResponse = Response.Loading
        val response = loadProduct(pid)
        productResponse = response
    }

}