package com.example.pizzaorder.screen.order

interface OrderInteractionListener {
    fun onChangePizzaSize(pizzaSize: PizzaSize, breadIndex: Int)
    fun onIngredientsClick(toppingIndex: Int, breadIndex: Int)
}