package com.sefio.suay.ui.screens.products_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.R
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.screens.products_list.ProductListViewModel
import com.sefio.suay.ui.theme.AppColor

@Composable
fun SearchBar(
    viewModel:ProductListViewModel = hiltViewModel(),
    textFieldColors: TextFieldColors = TextFieldDefaults.textFieldColors(
        disabledTextColor = Color.Transparent,
        backgroundColor = Color.White,
        focusedIndicatorColor = Color.LightGray,
        unfocusedIndicatorColor = Color.LightGray,
        disabledIndicatorColor = Color.LightGray,
        textColor = Color.DarkGray,
        placeholderColor = Color.DarkGray,
        cursorColor = Color.Gray,
        leadingIconColor = AppColor
    )
) {
    val state = viewModel.state

    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.name,
            onValueChange = {
                viewModel.onNameInput(it)
                viewModel.fetchProductsName()
            },
            placeholder = {
                Text(text = stringResource(id = R.string.search_your_products))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        viewModel.fetchProductsByName(state.name)
                    }
                )
            },
            colors = textFieldColors
        )

        when(val namesResponse = viewModel.namesResponse) {
            is Response.Success -> {
                NamesList(names = namesResponse.data, onClick = {
                    viewModel.fetchProductsByName(it)
                })
            }

            else -> {}
        }
    }
}