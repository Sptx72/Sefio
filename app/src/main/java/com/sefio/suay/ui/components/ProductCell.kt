package com.sefio.suay.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sefio.suay.domain.model.Product
import com.sefio.suay.ui.theme.AppColor

@Composable
fun ProductCell(
    product: Product
) {

    Column(
        modifier = Modifier
            .height(300.dp)
            .width(200.dp)
            .background(color = AppColor),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = "https://media.istockphoto.com/id/1270780643/es/foto/retrato-de-un-gran-le%C3%B3n-africano-macho.jpg?s=1024x1024&w=is&k=20&c=6pwfMA_9G8_aOCXm5KDEwtaLRtmY8juXpg55MAyKaPE=",
            contentDescription = "leoncito pa",
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(20.dp).clip(RoundedCornerShape(25)),
        )

        Column(
            modifier = Modifier.height(150.dp).padding(20.dp)
        ) {
            Text(text = product.name, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "${product.description}", color = Color.White)
        }
    }

}