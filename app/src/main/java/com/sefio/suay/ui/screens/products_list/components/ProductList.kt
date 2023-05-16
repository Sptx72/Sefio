package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.domain.model.Product
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.screens.products_list.ProductListViewModel

@Composable
fun ProductList(
    productList: List<Product>,
    productsListViewModel: ProductListViewModel = hiltViewModel()
) {
    Column {
        NormalText(text = productsListViewModel.productsCategory.value)
        Spacer(modifier = Modifier.height(30.dp))
        List(productList)

    }
}

@Composable
private fun List(
    list:List<Product>
) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        list.forEachIndexed { index, product ->
            if (index % 2 == 0) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProductContainer(product = product)
                    if (index + 1 != list.size) {
                        ProductContainer(product = list[index + 1])
                    }
                }
            }
        }
    }
}