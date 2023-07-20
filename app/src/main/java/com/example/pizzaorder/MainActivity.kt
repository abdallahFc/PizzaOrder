package com.example.pizzaorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzaorder.screen.order.PizzaOrderingScreen
import com.example.pizzaorder.ui.theme.PizzaOrderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaOrderTheme {
                PizzaOrderingScreen()
            }
        }
    }
}
