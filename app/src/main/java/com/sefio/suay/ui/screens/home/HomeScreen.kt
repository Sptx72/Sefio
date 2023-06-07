package com.sefio.suay.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sefio.suay.ui.navigation.HomeNavGraph
import com.sefio.suay.ui.screens.home.components.HomeBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navHostController: NavHostController = rememberNavController(),
    fatherNavHostController: NavHostController
) {
    Scaffold(
        modifier = Modifier.padding(top = 30.dp),
        content = {
                  HomeNavGraph(navHostController, fatherNavHostController)
        },
        bottomBar = {
            HomeBottomBar(navHostController)
        }
    )
}