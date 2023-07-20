package com.example.pizzaorder.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PizzaToppingItem(
    image: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(64.dp)
            .background(
                if (isSelected) Color(0XFFDBF3E2)
                else Color.Transparent, CircleShape
            ),
        onClick = onClick,
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = image),
            contentDescription = "Topping",
        )
    }
}