package com.sefio.suay.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NormalText(
    text:String,
    fontSize: TextUnit = 14.sp,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily.Default,
    modifier:Modifier = Modifier.fillMaxWidth(),
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
        textAlign = textAlign,
        fontWeight = fontWeight,
        fontFamily = fontFamily
    )
}