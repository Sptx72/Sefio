package com.sefio.suay.ui.navigation

import androidx.annotation.DrawableRes
import com.sefio.suay.R

sealed class AppScreen (val route:String) {

    object Home:AppScreen(route = "home")
    object SignIn:AppScreen(route = "signIn")
    object SignUp:AppScreen(route = "signUp")
    object ProductDetail:AppScreen(route = "product/detail")

    sealed class SubScreen (val route: String,@DrawableRes val icon: Int) {
        object ProductsList:SubScreen(route = "${Home.route}/productsList", R.drawable.ic_home)
        object Profile:SubScreen(route = "${Home.route}/profile", R.drawable.ic_profile)
        object Settings:SubScreen(route = "${Home.route}/settings", R.drawable.ic_menu)
        object ShoppingCart:SubScreen(route = "${Home.route}/shoppingCart", R.drawable.ic_cart)
    }

}
