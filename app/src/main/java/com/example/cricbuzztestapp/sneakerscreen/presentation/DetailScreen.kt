package com.example.cricbuzztestapp.sneakerscreen.presentation

import android.os.Handler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cricbuzztestapp.R
import com.example.cricbuzztestapp.navigation.Screen
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.ui.theme.widgets.ProductItemLayout
import com.example.cricbuzztestapp.util.AppConstants

@Composable
fun DetailScreenUI(viewmodel: HomeViewmodel, navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PageHeading()
        ProductName()
        ProductDetail(viewmodel)
        BuyButton(navController, viewmodel)

    }
}

@Composable
fun ProductDetail(viewmodel: HomeViewmodel) {
    Column {
        ProductItemLayout(
            image = R.drawable.pegasus_trail_3_gore_tex_dark_green,
            price = "159.00",
            title = "Pegasus Trail Gortex Green",
            handler = viewmodel.mainHandler,
            onProductClicked = { /*TODO*/ },
            onChangeCartState = { /*TODO*/ },
            viewmodel = viewmodel
        )
        ProductDetailText()
        YearOfManufacture()

    }
}

@Composable
fun PageHeading() {
    Text(
        text = "Product Detail",
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ProductDetailText() {
    Text(
        text = "The Nike Pegasus Trail 3 has the same comfort you love, with a design that nods to the classic Pegasus look.",
        color = Color.Black,
        textAlign = TextAlign.Start
    )
}

@Composable
fun YearOfManufacture() {
    Text(
        text = "Year Of Manufacture: 2022",
        color = Color.Black,
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun ProductName() {
    Text(
        text = "Pegasus Trail Gortex Green",
        style = MaterialTheme.typography.h2,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun BuyButton(navController: NavController, viewmodel: HomeViewmodel) {
    Button(
        onClick = { navController.currentBackStackEntry?.savedStateHandle?.set(AppConstants.ITEM_IN_CART, viewmodel.requestItems())
            navController.navigate(route = Screen.CheckoutScreen.route) },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Text(text = "Add to Cart",
        color = Color.Black,
        style = MaterialTheme.typography.caption)
    }
}