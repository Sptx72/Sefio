package com.sefio.suay.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sefio.suay.R
import com.sefio.suay.ui.components.DefaultTextField
import com.sefio.suay.ui.theme.AppColor
import com.sefio.suay.ui.theme.Shapes

@Composable
fun HomeSearchBar(
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp).background(AppColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultTextField(value = "", onValueChange = {}, placeHolder = "busca productos", widthModifier = Modifier.width(300.dp).padding(top = 20.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 20.dp)
        )
    }

}