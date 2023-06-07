package com.sefio.suay.ui.navigation

import androidx.annotation.DrawableRes
import com.sefio.suay.R

sealed class HomeScreen(val  route:String, @DrawableRes val icon:Int) {
    object List: HomeScreen(route = "list", R.drawable.ic_home)
    object Cart: HomeScreen(route = "cart", R.drawable.ic_cart)
    object Profile: HomeScreen(route = "profile", R.drawable.ic_profile)
    object Settings: HomeScreen(route = "settings", R.drawable.ic_menu)
    object ProductDetail: HomeScreen(route = "product_detail", 0)
}