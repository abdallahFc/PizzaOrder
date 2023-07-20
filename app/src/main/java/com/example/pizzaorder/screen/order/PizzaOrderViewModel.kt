package com.example.pizzaorder.screen.order


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaOrderingViewModel @Inject constructor() : ViewModel(), OrderInteractionListener {

    private val _state = MutableStateFlow(PizzaOrderUiState())
    val state = _state.asStateFlow()

    override fun onChangePizzaSize(pizzaSize: PizzaSize, breadIndex: Int) {
        _state.update {
            val breads = it.breads.toMutableList()
            val bread = breads[breadIndex]
            breads[breadIndex] = bread.copy(
                pizzaSize = pizzaSize,
                totalPrice = bread.defaultPrice + pizzaSize.price +
                        bread.toppings.filter { topping -> topping.isSelected }
                            .sumOf { topping -> topping.price },
            )

            it.copy(
                breads = breads,
            )
        }
    }

    override fun onIngredientsClick(toppingIndex: Int, breadIndex: Int) {
        _state.update {
            val breads = it.breads.toMutableList()
            val bread = breads[breadIndex]
            val toppings = bread.toppings.toMutableList()
            val topping = toppings[toppingIndex]

            toppings[toppingIndex] = topping.copy(
                isSelected = !topping.isSelected,
            )

            breads[breadIndex] = bread.copy(
                toppings = toppings,
                totalPrice = bread.totalPrice +
                        if (toppings[toppingIndex].isSelected) topping.price else -topping.price,
            )

            it.copy(
                breads = breads,
            )
        }
    }
}