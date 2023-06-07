package com.sefio.suay.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sefio.suay.ui.screens.home.HomeScreen
import com.sefio.suay.ui.screens.product_detail.ProductDetailScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController)

        composable(route = Graph.HOME) {
            HomeScreen(fatherNavHostController = navHostController)
        }

        composable(
            route = "${Graph.PRODUCT}/{${NavArgumentNames.ProductId}}",
            arguments = listOf(navArgument(NavArgumentNames.ProductId) { type = NavType.StringType })
        ) {
            val pid = it.arguments?.getString(NavArgumentNames.ProductId)
            ProductDetailScreen(pid = pid!!)
        }
    }
}