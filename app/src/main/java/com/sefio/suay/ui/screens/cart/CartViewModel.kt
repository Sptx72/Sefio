package com.sefio.suay.ui.screens.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.data.repository.UserRepository
import com.sefio.suay.domain.model.Order
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.usecases.UserOrders
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val userOrders: UserOrders
): ViewModel()  {

    var ordersResponse by mutableStateOf<Response<List<Order>>?>(null)
        private set

    fun fetchUserOrders() = viewModelScope.launch(Dispatchers.IO) {
        ordersResponse = Response.Loading
        val result = userOrders()
        ordersResponse = result
    }

}