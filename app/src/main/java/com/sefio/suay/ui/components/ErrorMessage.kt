package com.sefio.suay.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun ErrorMessage(
    text:String
) {
    Text(
        text = text,
        fontSize = 15.sp,
        color = Color.Red,
        textAlign = TextAlign.Center
    )
}