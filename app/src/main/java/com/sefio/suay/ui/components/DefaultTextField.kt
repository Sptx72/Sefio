package com.sefio.suay.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultTextField(
    widthModifier: Modifier = Modifier.fillMaxWidth(),
    value: String,
    errorMsg: String = "",
    onValueChange: (value: String)-> Unit,
    validateField: () -> Unit = {},
    placeHolder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    textFieldColors: TextFieldColors = TextFieldDefaults.textFieldColors(
        disabledTextColor = Color.Transparent,
        backgroundColor = Color.White,
        focusedIndicatorColor = Color.LightGray,
        unfocusedIndicatorColor = Color.LightGray,
        disabledIndicatorColor = Color.LightGray,
        textColor = Color.DarkGray,
        placeholderColor = Color.DarkGray,
        cursorColor = Color.Gray)
) {
    Column() {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                validateField()
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            placeholder = {
                Text(text = placeHolder)
            },
            shape = RoundedCornerShape(25),
            colors = textFieldColors,
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = widthModifier
        )

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = errorMsg,
            fontSize = 11.sp,
            color = Color.Red
        )
    }
}