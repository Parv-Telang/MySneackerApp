package com.example.cricbuzztestapp.sneakerscreen.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cricbuzztestapp.R
import com.example.cricbuzztestapp.sneakerscreen.data.Product
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.ui.theme.widgets.ProductItemLayout

@Composable
fun CheckOutUI(viewmodel: HomeViewmodel, itemsInCart: List<Product>, navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = { TopAppBarCheckOut(navController) },
        scaffoldState = scaffoldState
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                itemsInCart.forEach { item ->
                    ProductItemLayout(
                        image = item.shoe,
                        price = item.price,
                        title = item.name,
                        handler = viewmodel.mainHandler,
                        onProductClicked = { /*TODO*/ },
                        onChangeCartState = { /*TODO*/ },
                        viewmodel = viewmodel
                    )
                }

                ItemTotal()
                CheckoutButton()

            }
        }
    }

}

@Composable
fun TopAppBarCheckOut(navController: NavController) {
    TopAppBar(
        backgroundColor = Color.Cyan,
        title = { Text(text = "Checkout", style = MaterialTheme.typography.body1) },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                contentDescription = "",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
        })
}

@Composable
fun ItemTotal() {
    Text(
        text = "Total = $1191",
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(40.dp)
    )
}

@Composable
fun CheckoutButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Text(
            text = "Check Out",
            color = Color.Black,
            style = MaterialTheme.typography.caption
        )
    }
}