package com.example.cricbuzztestapp.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")
    object CheckoutScreen: Screen("checkout_screen")
}