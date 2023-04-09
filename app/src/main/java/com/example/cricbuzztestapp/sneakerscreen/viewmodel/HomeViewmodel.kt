package com.example.cricbuzztestapp.sneakerscreen.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cricbuzztestapp.R
import com.example.cricbuzztestapp.sneakerscreen.data.Product

class HomeViewmodel: ViewModel() {

    val mainHandler = Handler(Looper.getMainLooper())
    private val _buyItemsCount = mutableStateOf(0)
    val buyItemsCount: State<Int> = _buyItemsCount
    var itemsInCart= mutableListOf<Product>()

    fun removeBuyItemsCount() {
        if (_buyItemsCount.value > 0) {
            _buyItemsCount.value -= 1
        }
    }

    fun addBuyItemsCount() {
        if (_buyItemsCount.value < 100) {
            _buyItemsCount.value += 1
        }
    }

    fun addItemToCart() {
       itemsInCart.add(Product(id = 0, name = "Pegasus Trail Gortex Green", shoe = R.drawable.pegasus_trail_3_gore_tex_lemon, price = "149.0"))
    }
    fun removeItemFromCart() {
        if (buyItemsCount.value!= 0) {
            itemsInCart.remove(Product(id = 0, name = "Pegasus Trail Gortex Green", shoe = R.drawable.pegasus_trail_3_gore_tex_lemon, price = "149.0"))
        }
    }

    fun requestItems(): List<Product> {
        return listOf(
            Product(
                id = 1,
                name = "Pegasus Trail Gortex Green",
                shoe = R.drawable.pegasus_trail_3_gore_tex_dark_green,
                price = "149.0",
            ),
            Product(
                id = 2,
                name = "Pegasus Trail Gortex Lemon",
                shoe = R.drawable.pegasus_trail_3_gore_tex_lemon,
                price = "155.0",
            ),
            Product(
                id = 3,
                name = "Air Huarache Gold",
                shoe = R.drawable.air_huarache_le_gold_black,
                price = "159.0",
            ),
            Product(
                id = 4,
                name = "Air Huarache Gray",
                shoe = R.drawable.air_huarache_le_gray_dark,
                price = "149.0",
            ),
            Product(
                id = 5,
                name = "Air Huarache Pink",
                shoe = R.drawable.air_huarache_le_pink_black,
                price = "125.0",
            ),
            Product(
                id = 6,
                name = "Air Huarache Red",
                shoe = R.drawable.air_huarache_le_red_black,
                price = "145.0",
            ),
            Product(
                id = 7,
                name = "Blazer Low Black",
                shoe = R.drawable.blazer_low_black,
                price = "120.0",
            ),
            Product(
                id = 8,
                name = "Dunk Slow Black",
                shoe = R.drawable.dunk_slow_black,
                price = "189.99",
            ),
            Product(
                id = 9,
                name = "Dunk Slow Pink",
                shoe = R.drawable.dunk_slow_pink,
                price = "170.0",
            )
        )
    }
}