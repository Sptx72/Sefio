package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.domain.model.NavOption
import com.sefio.suay.domain.model.ProductCategory
import com.sefio.suay.ui.components.AppName
import com.sefio.suay.ui.screens.products_list.ProductListViewModel

@Composable
fun ProductListTopBar(
    productListViewModel: ProductListViewModel = hiltViewModel()
) {
    val navOptions = listOf(
        ProductCategory.Recommended,
        ProductCategory.Clothes,
        ProductCategory.Technology,
        ProductCategory.Perfumery,
    )

    Column {
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            AppName()
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar()
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            navOptions.forEach {
                ProductsNavOption(
                    title = it.value,
                    onClick = {
                        productListViewModel.fetchProductsByCategory(it)
                    }
                )
            }
        }
    }
}