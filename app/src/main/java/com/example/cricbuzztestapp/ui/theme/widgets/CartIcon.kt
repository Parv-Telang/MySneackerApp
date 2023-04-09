package com.example.cricbuzztestapp.ui.theme.widgets

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cricbuzztestapp.R
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ReactiveCartIcon(
    modifier: Modifier = Modifier,
    isOnCart: Boolean,
    onCartChange: () -> Unit,
    viewModel: HomeViewmodel
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.ic_minus),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .wrapContentWidth()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    viewModel.removeBuyItemsCount()
                    viewModel.removeItemFromCart()
                }
        )

        Spacer(modifier = Modifier.width(0.03.dp))
        AnimatedContent(
            targetState = viewModel.buyItemsCount.value,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(SizeTransform(clip = false))
            }
        ) { targetCount ->
            Text(
                text = "$targetCount",
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.width(0.03.dp))

        Image(
            painterResource(id = R.drawable.ic_plus),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier

                .wrapContentWidth()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    viewModel.addBuyItemsCount()
                    viewModel.addItemToCart()
                }
        )
    }


}