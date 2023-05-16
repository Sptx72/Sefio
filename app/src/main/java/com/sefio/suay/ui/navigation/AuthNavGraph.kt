package com.sefio.suay.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sefio.suay.ui.screens.login.LoginScreen
import com.sefio.suay.ui.screens.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navHostController = navHostController)
        }
        
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(navHostController = navHostController)
        }
    }
}