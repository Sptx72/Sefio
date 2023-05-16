package com.sefio.suay.ui.screens.products_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sefio.suay.ui.screens.products_list.components.ProductListContent
import com.sefio.suay.ui.screens.products_list.components.ProductListTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductListScreen(
    navHostController: NavHostController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ProductListTopBar()
        },
        content = {
            ProductListContent(navHostController = navHostController)
        }
    )
}