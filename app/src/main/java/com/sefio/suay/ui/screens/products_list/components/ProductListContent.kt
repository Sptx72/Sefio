package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.ErrorMessage
import com.sefio.suay.ui.components.WaitScreen
import com.sefio.suay.ui.screens.products_list.ProductListViewModel

@Composable
fun ProductListContent(
    viewModel: ProductListViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    when(val response = viewModel.productsResponse) {
        is Response.Loading -> {
            WaitScreen()
        }

        is Response.Failure -> {
            ErrorMessage(text = response.e.message!!)
        }

        is Response.Success -> {
            ProductList(productList = response.data)
        }

        else -> {
            viewModel.fetchRecommendedProducts()
        }
    }
}