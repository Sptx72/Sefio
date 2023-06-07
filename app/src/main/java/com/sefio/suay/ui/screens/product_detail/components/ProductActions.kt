package com.sefio.suay.ui.screens.product_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Preview
@Composable
fun ProductActions(

) {
    val buttonModifier = Modifier
        .fillMaxWidth()

    val textModifier = Modifier
        .padding(10.dp)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(30.dp)
            .zIndex(1f)
            ) {
        Button(onClick = {  }, modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00C2FF))) {
            Text(text = "COMPRAR", color = Color.White, modifier = textModifier)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {  }, modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
            Text(text = "AÑADIR A LA CESTA", color = Color.White, modifier = textModifier)
        }
    }
}