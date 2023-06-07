package com.sefio.suay.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpandedText(
    text:String
) {

    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = 30.dp),
        contentAlignment = Alignment.Center
    ) {

        NormalText(text = text)

    }

}