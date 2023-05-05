package com.sefio.suay.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sefio.suay.ui.screens.home.HomeScreen
import com.sefio.suay.ui.screens.signin.SignInScreen

@Composable
fun AppNavigator(
    navHostController: NavHostController,
    startDestination:String = AppScreen.SubScreen.ProductsList.route
) {
    
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = AppScreen.SubScreen.ShoppingCart.route) {
            HomeScreen(navHostController = navHostController, subScreen = AppScreen.SubScreen.ShoppingCart)
        }

        composable(route = AppScreen.SubScreen.Settings.route) {
            HomeScreen(navHostController = navHostController, subScreen = AppScreen.SubScreen.Settings)
        }

        composable(route = AppScreen.SubScreen.Profile.route) {
            HomeScreen(navHostController = navHostController, subScreen = AppScreen.SubScreen.Profile)
        }

        composable(route = AppScreen.SubScreen.ProductsList.route) {
            HomeScreen(navHostController = navHostController, subScreen = AppScreen.SubScreen.ProductsList)
        }
        
        composable(route = AppScreen.SignIn.route) {
            SignInScreen(navHostController = navHostController)
        }
    }
    
}