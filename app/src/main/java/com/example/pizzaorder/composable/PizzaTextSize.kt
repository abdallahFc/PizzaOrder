package com.example.pizzaorder.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PizzaTextSize(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .size(48.dp)
            .wrapContentHeight()
            .clickable { onClick() },
        text = text,
        textAlign = TextAlign.Center,
        color = Color.Black,
        style = MaterialTheme.typography.bodyLarge,
    )
}