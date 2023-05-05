package com.sefio.suay.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefio.suay.ui.theme.AppColor

@Composable
fun DefaultButton(
    text: String,
    onCLick: () -> Unit,
    enabled: Boolean = true
) {

    Spacer(modifier = Modifier.height(30.dp))

    Button(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .height(60.dp)
            .widthIn(300.dp),
        onClick = { onCLick() },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = AppColor)) {

        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

    }

}