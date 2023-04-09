package com.example.cricbuzztestapp.sneakerscreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cricbuzztestapp.navigation.Screen
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.util.AppConstants

@Composable
fun HomeScreen(viewmodel: HomeViewmodel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "Nike.",
                style = MaterialTheme.typography.body1.copy(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = MaterialTheme.colors.onBackground,
                )
            )
            Icon(
                painter = painterResource(id = com.example.cricbuzztestapp.R.drawable.ic_nike_icon),
                contentDescription = "logo",
                modifier = Modifier.size(36.dp),
                tint = MaterialTheme.colors.primary,
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { navController.currentBackStackEntry?.savedStateHandle?.set(
                        AppConstants.ITEM_IN_CART, viewmodel.requestItems())
                        navController.navigate(Screen.CheckoutScreen.route) }
                    .padding(6.dp)
            ){
                Icon(
                    painter = painterResource(id = com.example.cricbuzztestapp.R.drawable.ic_shopping_bag),
                    contentDescription = "cart",
                    modifier = Modifier
                        .size(30.dp),
                    tint = MaterialTheme.colors.onBackground.copy(alpha = 0.7f),
                )            }
        }
        ProductLandingUI(viewmodel = viewmodel, navController)
    }
}