package com.sefio.suay.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.model.User
import com.sefio.suay.domain.usecases.SignIn
import com.sefio.suay.ui.screens.login.components.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signIn: SignIn
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var loginResponse by mutableStateOf<Response<Nothing>?>(null)

    fun onEmailInput(email:String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String) {
        state = state.copy(password = password)
    }

    fun onError(error:String) {
        state = state.copy(errorMessage = error)
    }

    fun signInUser() = viewModelScope.launch(Dispatchers.IO) {
        loginResponse = Response.Loading
        val result = signIn(email = state.email, password = state.password)
        loginResponse = result
    }

}