package com.example.pizzaorder.screen.order.composable

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.composable.PizzaTextSize
import com.example.pizzaorder.screen.order.PizzaSize

@Composable
fun PizzaSizes(
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
    onSizeClick: (PizzaSize) -> Unit,
) {
    val position by animateDpAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.dp
            PizzaSize.MEDIUM -> 48.dp
            PizzaSize.LARGE -> 95.dp
        }, label = "size Animation",
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .matchParentSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier
                    .size(48.dp)
                    .offset(x = position, y = 0.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
            ) {

            }
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PizzaTextSize(
                text = "S",
                onClick = { onSizeClick(PizzaSize.SMALL) },
            )
            PizzaTextSize(
                text = "M",
                onClick = { onSizeClick(PizzaSize.MEDIUM) },
            )
            PizzaTextSize(
                text = "L",
                onClick = { onSizeClick(PizzaSize.LARGE) },
            )
        }
    }
}