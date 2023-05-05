package com.sefio.suay.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.ErrorScreen
import com.sefio.suay.ui.components.WaitScreen
import com.sefio.suay.ui.navigation.AppScreen
import com.sefio.suay.ui.screens.products.ProductsList
import com.sefio.suay.ui.screens.profile.Profile
import com.sefio.suay.ui.screens.settings.Settings
import com.sefio.suay.ui.screens.shopping_cart.ShoppingCart

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    subScreen: AppScreen.SubScreen
) {
    val loggedFlow = homeViewModel.loggedFlow.collectAsState()

    loggedFlow.value.let {
        when (it) {
            is Response.Loading -> {
                WaitScreen()
            }

            is Response.Success -> {
                val isLogged = it.data
                ShowScreenOrRegret(isLogged = isLogged, navHostController = navHostController, homeViewModel = homeViewModel, subScreen = subScreen)
            }

            is Response.Failure -> {
                ErrorScreen(text = it.e.message!!)
            }

            else -> {
                if (it == null) homeViewModel.checkUserStatus()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ShowScreenOrRegret(
    isLogged:Boolean,
    navHostController:NavHostController,
    homeViewModel: HomeViewModel,
    subScreen: AppScreen.SubScreen
) {
    if (!isLogged) {
        navHostController.navigate(AppScreen.SignIn.route)
    } else {
        Scaffold(
            topBar = {
                     HomeSearchBar(navHostController = navHostController)
            },
            content = {
                      when (subScreen) {
                          is AppScreen.SubScreen.ProductsList -> {
                              ProductsList(navHostController = navHostController)
                          }

                          is AppScreen.SubScreen.Settings -> {
                              Settings()
                          }

                          is AppScreen.SubScreen.ShoppingCart -> {
                              ShoppingCart()
                          }

                          is AppScreen.SubScreen.Profile -> {
                              Profile()
                          }
                      }
            },
            bottomBar = {
                HomeBottomNavigation(navHostController = navHostController)
            }
        )
    }
}