package com.sefio.suay.ui.screens.cart.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.R
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.ErrorMessage
import com.sefio.suay.ui.components.ExpandedText
import com.sefio.suay.ui.components.WaitScreen
import com.sefio.suay.ui.screens.cart.CartViewModel

@Composable
fun CartContent(
    cartViewModel: CartViewModel = hiltViewModel()
) {

    when(val response = cartViewModel.ordersResponse) {

        is Response.Failure -> {
            response.e.message?.let { ErrorMessage(text = it) }
        }

        is Response.EmptySuccess -> {
            ExpandedText(text = stringResource(id = R.string.no_orders_founded))
        }

        is Response.Loading -> {
            WaitScreen()
        }

        is Response.Success -> {
            OrdersList(orders = response.data)
        }

        else -> {
            LaunchedEffect(Unit) {
                if (response == null) cartViewModel.fetchUserOrders()
            }
        }
    }

}