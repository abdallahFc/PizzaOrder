package com.example.pizzaorder.screen.order.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToppingItem(
    image: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isSelected,
        enter = scaleIn(
            initialScale = 10f,
        ) + fadeIn(),
        exit = fadeOut(),
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = image),
            contentDescription = "Bread"
        )
    }
}

