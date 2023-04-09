package com.example.cricbuzztestapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cricbuzztestapp.sneakerscreen.data.Product
import com.example.cricbuzztestapp.sneakerscreen.presentation.CheckOutUI
import com.example.cricbuzztestapp.sneakerscreen.presentation.DetailScreenUI
import com.example.cricbuzztestapp.sneakerscreen.presentation.HomeScreen
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.util.AppConstants

@Composable
fun ScreenNavigation(
    context: Context,
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            ScreenNavigationToHomeScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route
//                .plus(AppConstants.PRODUCT_IMAGE_ARG + "{${AppConstants.PRODUCT_IMAGE}}")
//                .plus(AppConstants.PRODUCT_NAME_ARG + "{${AppConstants.PRODUCT_NAME}}")
//                .plus(AppConstants.PRODUCT_PRICE_ARG + "{${AppConstants.PRODUCT_PRICE}}"),
//            arguments = listOf(
//                navArgument(AppConstants.PRODUCT_IMAGE) {
//                type = NavType.IntType
//                defaultValue = com.example.cricbuzztestapp.R.drawable.pegasus_trail_3_gore_tex_dark_green
//            },
//                navArgument(AppConstants.PRODUCT_NAME) {
//                    type = NavType.StringType
//                    defaultValue = ""
//                },
//                navArgument(AppConstants.PRODUCT_PRICE) {
//                    type = NavType.StringType
//                    defaultValue = ""
//                }
//            )
        ) {
            ScreenNavToDetailScreen(it, navController)
        }
        composable(
            route = Screen.CheckoutScreen.route
        ){
            val viewmodel = HomeViewmodel()
            val itemsInCart = navController.previousBackStackEntry?.savedStateHandle?.get<List<Product>>(AppConstants.ITEM_IN_CART)
            if (itemsInCart != null) {
                CheckOutUI(viewmodel,itemsInCart, navController)
            }
        }
    }
}

@Composable
fun ScreenNavigationToHomeScreen(navController: NavHostController) {
    val homeViewModel = HomeViewmodel()
    HomeScreen(viewmodel = homeViewModel, navController)
}

@Composable
fun ScreenNavToDetailScreen(entry: NavBackStackEntry, navController: NavController) {
    val homeViewModel = HomeViewmodel()
//    val image = entry.arguments?.getInt(AppConstants.PRODUCT_IMAGE_ARG)?: com.example.cricbuzztestapp.R.drawable.pegasus_trail_3_gore_tex_dark_green
//    val name = entry.arguments?.getString(AppConstants.PRODUCT_NAME_ARG)?: ""
//    val price = entry.arguments?.getString(AppConstants.PRODUCT_PRICE_ARG)?: ""
//    println("$image")
    DetailScreenUI(viewmodel = homeViewModel, navController)
}