package com.sefio.suay.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefio.suay.ui.theme.AppColor

@Composable
fun Title(
    text: String,
    fontColor: Color = AppColor
) {

    Spacer(modifier = Modifier.height(30.dp))

    Text(
        modifier = Modifier.padding(horizontal = 30.dp),
        text = text,
        fontSize = 45.sp,
        color = fontColor,
        fontWeight = FontWeight.Bold)

}