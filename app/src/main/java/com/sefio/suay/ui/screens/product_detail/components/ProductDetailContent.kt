package com.sefio.suay.ui.screens.product_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefio.suay.domain.model.Product
import com.sefio.suay.ui.components.NormalText

@Composable
fun ProductDetailContent(
    product: Product
) {
    val textModifier = Modifier.padding(vertical = 10.dp)
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(30.dp)
        ) {
            NormalText(
                text = "${product.description}",
                textAlign = TextAlign.Justify,
                fontSize = 20.sp,
                modifier = textModifier
            )

            Text(text = "Marca: ${product.brand}", color = Color(0xFF00C2FF), modifier = textModifier, fontWeight = FontWeight.Bold)

            Row {
                if (product.discount > 0)
                    Text(text = "${product.discount}% ", color = Color.Red, modifier = textModifier, fontWeight = FontWeight.Bold)
                Text(text = " ${product.price}€", modifier = textModifier, fontWeight = FontWeight.Bold)
            }

            Text(text = "Acerca del producto", modifier = textModifier)
        }

        ProductActions()
    }


    
}