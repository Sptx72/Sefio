package com.sefio.suay.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sefio.suay.domain.model.ListType
import com.sefio.suay.ui.navigation.HomeScreen
import com.sefio.suay.ui.theme.AppColor

@Composable
fun HomeBottomBar(
    navHostController: NavHostController
) {
    val items = listOf(
        HomeScreen.List,
        HomeScreen.Cart,
        HomeScreen.Profile,
        HomeScreen.Settings
    )

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = AppColor
    ) {
        val navStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                icon = {
                    Icon(painter = painterResource(id = screen.icon), contentDescription = screen.route, tint = Color.Unspecified)
                },
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}