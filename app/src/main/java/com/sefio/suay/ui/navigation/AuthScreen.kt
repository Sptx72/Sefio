package com.sefio.suay.ui.navigation

sealed class AuthScreen (val route:String) {
    object Login: AuthScreen(route = "login")
    object SignUp: AuthScreen(route = "signUp")
}
