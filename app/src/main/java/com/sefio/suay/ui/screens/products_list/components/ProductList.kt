package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.domain.model.Product
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.screens.products_list.ProductListViewModel
import com.sefio.suay.R

@Composable
fun ProductList(
    productList: List<Product>,
    productsListViewModel: ProductListViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    Column {
        NormalText(text = productsListViewModel.productsCategory.value)
        Spacer(modifier = Modifier.height(30.dp))
        List(productList, navHostController)
    }
}

@Composable
private fun List(
    list:List<Product>,
    navHostController: NavHostController
) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        list.forEachIndexed { index, product ->
            if (index % 2 == 0) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProductContainer(product = product, navHostController = navHostController)
                    if (index + 1 != list.size) {
                        ProductContainer(product = list[index + 1], navHostController = navHostController)
                    }
                }
            }
        }
    }
}