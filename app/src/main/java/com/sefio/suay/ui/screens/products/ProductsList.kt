package com.sefio.suay.ui.screens.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.ErrorScreen
import com.sefio.suay.ui.components.ProductCell
import com.sefio.suay.ui.components.Title
import com.sefio.suay.ui.components.WaitScreen

@Composable
fun ProductsList(
    navHostController: NavHostController,
    viewModel: ProductsListViewModel = hiltViewModel()
) {
    Column {
        RecommendedProductsList(viewModel = viewModel)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RecommendedProductsList(
    viewModel: ProductsListViewModel
) {
    val recommendedProductsFlow = viewModel.recommendedProductsFlow.collectAsState()
    val shouldShowWaitScreen by remember { mutableStateOf(false) }
    val errorMsg by remember { mutableStateOf("") }

    recommendedProductsFlow.value.let {
        when (it) {
            is Response.Loading -> {
                WaitScreen()
            }

            is Response.Failure -> {
                ErrorScreen(text = it.e.message!!)
            }

            is Response.Success -> {
                Title(text = "Productos recomendados para ti")

                ScrollableTabRow(
                    selectedTabIndex = 0,
                    backgroundColor = Color.White,
                    divider = {
                    Divider(color = Color.LightGray, thickness = 2.dp)
                    },
                    edgePadding = 0.dp,
                ) {
                    it.data.map { p ->
                        ProductCell(product = p)
                    }
                }

            }

            else -> {
                if (recommendedProductsFlow.value == null) viewModel.fetchRecommendedProducts()
            }
        }
    }
}