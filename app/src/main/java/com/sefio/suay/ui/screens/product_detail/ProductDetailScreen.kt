package com.sefio.suay.ui.screens.product_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.ErrorMessage
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.components.WaitScreen
import com.sefio.suay.ui.screens.product_detail.components.ProductDetailContent

@Composable
fun ProductDetailScreen(
    pid:String,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
        when (val response = productDetailViewModel.productResponse) {
            is Response.Loading -> {
                WaitScreen()
            }

            is Response.Failure -> {
                ErrorMessage(text = response.e.message!!)
            }

            is Response.Success -> {
                ProductDetailContent(product = response.data)
            }

            else -> {
                LaunchedEffect(Unit) {
                    if (response == null) productDetailViewModel.fetchProduct(pid)
                }
            }
        }

}