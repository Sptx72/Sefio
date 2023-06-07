package com.sefio.suay.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sefio.suay.ui.screens.cart.CartScreen
import com.sefio.suay.ui.screens.product_detail.ProductDetailScreen
import com.sefio.suay.ui.screens.products_list.ProductListScreen
import com.sefio.suay.ui.screens.profile.ProfileScreen
import com.sefio.suay.ui.screens.settings.SettingsScreen

@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    fatherNavHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = HomeScreen.List.route
    ) {
        composable(route = HomeScreen.List.route) {
            ProductListScreen(fatherNavHostController)
        }
        composable(route = HomeScreen.Cart.route) {
            CartScreen(navHostController)
        }

        composable(route = HomeScreen.Profile.route) {
            ProfileScreen(navHostController)
        }

        composable(route = HomeScreen.Settings.route) {
            SettingsScreen(navHostController)
        }
    }
}