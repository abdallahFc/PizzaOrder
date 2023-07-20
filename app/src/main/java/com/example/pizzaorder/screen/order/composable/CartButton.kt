package com.example.pizzaorder.screen.order.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF372B29),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "Add to cart",
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Add to cart",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}