package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sefio.suay.R
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.theme.AppColor

@Composable
fun ProductsNavOption(
    title:String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily:FontFamily = FontFamily.Default,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .padding(vertical = 5.dp)
        .clickable { onClick()  }
        .drawBehind {
            val strokeWidth = 1f
            val y = size.height + 10f
            drawLine(
                Color.LightGray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }
) {

    NormalText(
        text = title,
        modifier = modifier,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
    )
}