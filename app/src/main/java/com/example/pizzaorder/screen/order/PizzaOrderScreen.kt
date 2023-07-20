@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)

package com.example.pizzaorder.screen.order
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaorder.R
import com.example.pizzaorder.composable.PizzaToppingItem
import com.example.pizzaorder.screen.order.composable.BreadPager
import com.example.pizzaorder.screen.order.composable.CartButton
import com.example.pizzaorder.screen.order.composable.PizzaOrderingTopBar
import com.example.pizzaorder.screen.order.composable.PizzaSizes
import com.example.pizzaorder.ui.theme.PizzaOrderTheme

@Composable
fun PizzaOrderingScreen(
    viewModel: PizzaOrderingViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    PizzaOrderingContent(
        state,
        onSizeClick = viewModel::onChangePizzaSize,
        onToppingClick = viewModel::onIngredientsClick
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PizzaOrderingContent(
    state: PizzaOrderUiState,
    onSizeClick: (PizzaSize, Int) -> Unit,
    onToppingClick: (Int, Int) -> Unit,
) {
    Scaffold(
        containerColor = Color.White,
        topBar = { PizzaOrderingTopBar() }
    ) { paddings ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddings.calculateTopPadding(),
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val pagerState = rememberPagerState(0)

            BreadPager(
                pagerState = pagerState,
                breads = state.breads,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .height(232.dp)
                    .fillMaxWidth()
                    .paint(
                        painter = painterResource(id = R.drawable.plate),
                        contentScale = ContentScale.Inside,
                    )
            )

            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "$${state.breads[pagerState.currentPage].totalPrice}",
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
            )

            PizzaSizes(
                pizzaSize = state.breads[pagerState.currentPage].pizzaSize,
                modifier = Modifier.padding(top = 16.dp),
                onSizeClick = { size -> onSizeClick(size, pagerState.currentPage) },
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp),
                text = "Customize your pizza".uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                itemsIndexed(
                    state.breads[pagerState.currentPage].toppings,
                    key = { _, item -> item.id }) { index, topping ->
                    PizzaToppingItem(
                        image = topping.mainImage,
                        isSelected = topping.isSelected,
                        onClick = { onToppingClick(index, pagerState.currentPage) },
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            CartButton(
                modifier = Modifier.padding(bottom = 64.dp),
            )
        }
    }
}

@Preview
@Composable
fun PizzaOrderingScreenPreview() {
    PizzaOrderTheme {
        PizzaOrderingScreen()
    }
}
