package com.example.pizzaorder.screen.order

import com.example.pizzaorder.R


data class PizzaOrderUiState(
    val id: Int = 0,
    val breads: List<Bread> = breadsList,
)

data class Bread(
    val id: Int = 0,
    val image: Int = 0,
    val defaultPrice: Int = 0,
    val totalPrice: Int = 0,
    var pizzaSize: PizzaSize = PizzaSize.SMALL,
    val toppings: List<Topping> = toppingList
)

data class Topping(
    val id: Int = 0,
    val name: String = "",
    val mainImage: Int = 0,
    val price: Int = 0,
    val image: Int = 0,
    var isSelected: Boolean = false,
)


val toppingList=listOf(
    Topping(
        1, "Basil", R.drawable.basil_3, 2, R.drawable.basil_group,
    ),
    Topping(
        2, "Onion", R.drawable.onion_3, 4, R.drawable.onion_group,
    ),
    Topping(
        3, "Broccoli", R.drawable.broccoli_3, 6, R.drawable.brocoli_group,
    ),
    Topping(
        4, "Mushroom", R.drawable.mushroom_3, 8, R.drawable.mushroom_group,
    ),
    Topping(
        5, "Sausage", R.drawable.sausage_3, 10,
        R.drawable.susage_group,
    ),
)
val breadsList=listOf(
    Bread(1, R.drawable.bread_1, 50, 50, PizzaSize.SMALL, toppingList),
    Bread(2, R.drawable.bread_2, 55, 55, PizzaSize.SMALL, toppingList),
    Bread(3, R.drawable.bread_3, 60, 60, PizzaSize.SMALL, toppingList),
    Bread(4, R.drawable.bread_4, 65, 65, PizzaSize.SMALL, toppingList),
    Bread(5, R.drawable.bread_5, 70, 70, PizzaSize.SMALL, toppingList),
)





