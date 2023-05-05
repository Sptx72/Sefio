package com.sefio.suay.ui.screens.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.sefio.suay.ui.navigation.AppScreen
import com.sefio.suay.ui.theme.AppColor

@Composable
fun HomeBottomNavigation(
    navHostController: NavHostController
) {
    val items = listOf(
        AppScreen.SubScreen.ProductsList,
        AppScreen.SubScreen.ShoppingCart,
        AppScreen.SubScreen.Profile,
        AppScreen.SubScreen.Settings
    )

    BottomNavigation(
        backgroundColor = AppColor
    ) {
        val currentRoute = navHostController.currentDestination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = "bottom label",
                        tint = Color.Unspecified
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navHostController.navigate(screen.route)
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}