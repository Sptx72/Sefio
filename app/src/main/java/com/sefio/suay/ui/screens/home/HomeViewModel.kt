package com.sefio.suay.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.usecases.IsLogged
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val isLogged: IsLogged
) : ViewModel()  {

    private val _loggedFlow = MutableStateFlow<Response<Boolean>?>(null)
    val loggedFlow:StateFlow<Response<Boolean>?> = _loggedFlow

    fun checkUserStatus() = viewModelScope.launch(Dispatchers.IO) {
        _loggedFlow.value = Response.Loading
        val result = isLogged()
        _loggedFlow.value = result
    }

    fun loadUser() {

    }

}