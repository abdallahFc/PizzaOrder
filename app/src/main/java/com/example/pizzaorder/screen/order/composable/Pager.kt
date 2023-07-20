package com.example.pizzaorder.screen.order.composable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.screen.order.Bread
import com.example.pizzaorder.screen.order.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(
    pagerState: PagerState,
    breads: List<Bread>,
    modifier: Modifier = Modifier
) {

    HorizontalPager(
        pageCount = breads.size,
        modifier = modifier,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val pizzaSize by animateDpAsState(
            when (breads[it].pizzaSize) {
                PizzaSize.SMALL -> 32.dp
                PizzaSize.MEDIUM -> 24.dp
                PizzaSize.LARGE -> 16.dp
            }, label = "size Animation",
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        Box(
            modifier = Modifier
                .padding(pizzaSize)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = breads[it].image),
                modifier = Modifier
                    .fillMaxSize(),
                contentDescription = "Bread"
            )

            for (item in breads[it].toppings) {
                ToppingItem(
                    image = item.image,
                    isSelected = item.isSelected,
                    modifier = Modifier
                        .size(180.dp)
                        .padding(pizzaSize)
                )
            }
        }
    }
}
