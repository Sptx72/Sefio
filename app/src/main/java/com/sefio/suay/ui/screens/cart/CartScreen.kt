package com.sefio.suay.ui.screens.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.screens.cart.components.CartContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {

        },
        content = {

        },
        bottomBar = {

        }
    )

    CartContent()
}