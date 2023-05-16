package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.sefio.suay.domain.model.Product
import com.sefio.suay.ui.navigation.Graph
import com.sefio.suay.ui.navigation.NavArgumentNames

@Composable
fun ProductContainer(
    product: Product,
) {
    Card(
        modifier = Modifier
            .width(175.dp)
            .height(250.dp)
            .padding(start = 5.dp, end = 5.dp)
            .clickable {

            },
        backgroundColor = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            AsyncImage(
                model = "https://cdn.pixabay.com/photo/2017/10/25/16/54/african-lion-2888519_1280.jpg",
                contentDescription = "",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )
            
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .height(125.dp)
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
            ) {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = "${product.description}", maxLines = 2, overflow = TextOverflow.Ellipsis)
                Text(text = "${product.stars}")
            }
        }
    }
}