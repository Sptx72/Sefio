package com.sefio.suay.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallText(
    text: String,
    onCLick: () -> Unit
) {

    Text(
        modifier = Modifier
            .clickable { onCLick() }
            .padding(vertical = 15.dp),
        text = text,
        fontSize = 12.sp,
        color = Color.LightGray)

}