package com.sefio.suay.ui.screens.signin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.model.User
import com.sefio.suay.domain.usecases.SignIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signIn: SignIn
): ViewModel() {
    val email:MutableState<String> = mutableStateOf("")
    val password:MutableState<String> = mutableStateOf("")

    private val _signInFlow = MutableStateFlow<Response<User>?>(null)
    val signInFlow:StateFlow<Response<User>?> = _signInFlow

    fun signUser() = viewModelScope.launch(Dispatchers.IO) {
        _signInFlow.value = Response.Loading
        val result = signIn(email = email.value, password = password.value)
        _signInFlow.value = result
    }
}