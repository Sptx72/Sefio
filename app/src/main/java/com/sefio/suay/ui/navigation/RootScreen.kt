package com.sefio.suay.ui.navigation

sealed class RootScreen(val route:String) {
    object HOME: RootScreen("home")
}