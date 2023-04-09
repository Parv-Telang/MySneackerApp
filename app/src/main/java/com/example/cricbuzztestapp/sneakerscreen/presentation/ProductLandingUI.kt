package com.example.cricbuzztestapp.sneakerscreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cricbuzztestapp.navigation.Screen
import com.example.cricbuzztestapp.sneakerscreen.data.Product
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.ui.theme.widgets.HomeProductItemLayout
import com.example.cricbuzztestapp.ui.theme.widgets.ProductItemLayout
import com.example.cricbuzztestapp.ui.theme.widgets.SearchField

@Composable
fun ProductLandingUI(viewmodel: HomeViewmodel, navController: NavController) {

    /** We just want a fake list of products */
    val allProducts = viewmodel.requestItems()
    val displayedProducts: MutableList<Product> = remember { mutableStateListOf() }
    val cartProductsIds: MutableList<Int> = remember { mutableStateListOf() }


    var searchQuery by remember { mutableStateOf("") }.also {
        /** Init the first filtered list, which is all product */
        displayedProducts.addAll(allProducts)
    }
    /** The handler that we use to controller timing the animations */
//    val mainHandler = Handler(Looper.getMainLooper())

    /** The dynamic typing data */
    val fullSubtitle = remember {"Just do it. ✅"}
    var currentlyTypedSubtitle by remember { mutableStateOf("")}

    val subtitleTypingCallback = remember {
        object : Runnable {
            override fun run() {
                /** Update the currently typed subtitle */
                if(currentlyTypedSubtitle.length < fullSubtitle.length){
                    currentlyTypedSubtitle += fullSubtitle[currentlyTypedSubtitle.length]
                } else {
                    currentlyTypedSubtitle = ""
                }
                viewmodel.mainHandler.postDelayed(this,300)
            }
        }
    }
    LaunchedEffect(key1 = Unit){
        viewmodel.mainHandler.post(subtitleTypingCallback)
    }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 15.dp),
    ) {
        /** Dynamic typing text */
        item(
            span = {
                GridItemSpan(2)
            }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 36.dp),
                text = currentlyTypedSubtitle,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 10.sp,
                ),
            )
        }

        /** Search field section */
        item(
            span = {
                GridItemSpan(2)
            }
        ) {
            SearchField(
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.4f),
                textColor = MaterialTheme.colors.onSurface,
                value = searchQuery,
                placeholder = "Let's help you, type name...",
                onValueChange = {
                    searchQuery = it
                    /** Then filter the list */
                    displayedProducts.clear()
                    displayedProducts.addAll(
                        allProducts.filter { product ->
                            product.name.startsWith(searchQuery, true)
                        }
                    )
                },
                onFocusChange = {

                },
                onKeyboardActionClicked = {

                }
            )
        }
        /** The grid items */
        itemsIndexed(displayedProducts, key =  {index, item -> item.id }) { index, product->
            HomeProductItemLayout(
                modifier = Modifier.fillMaxWidth(),
                image = product.shoe,
                price = product.price,
                title = product.name,
                onCart = product.id in cartProductsIds,
                onProductClicked = {
                    navController.navigate(route = Screen.DetailScreen.route)

                },
                onChangeCartState = {
                    /** Updating our cart state */
                    if (product.id in cartProductsIds) {
                        cartProductsIds.remove(product.id)
                    } else {
                        cartProductsIds.add(product.id)
                    }
                },
                handler = viewmodel.mainHandler,
                viewmodel = viewmodel
            )


        }
    }
}

