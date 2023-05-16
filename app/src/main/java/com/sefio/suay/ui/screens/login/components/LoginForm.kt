package com.sefio.suay.ui.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.sefio.suay.R
import com.sefio.suay.ui.components.DefaultButton
import com.sefio.suay.ui.components.DefaultTextField
import com.sefio.suay.ui.components.ErrorMessage
import com.sefio.suay.ui.screens.login.LoginViewModel

@Composable
fun LoginForm(
    loginViewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val state = loginViewModel.state

        DefaultTextField(
            value = state.email,
            onValueChange = {
                loginViewModel.onEmailInput(it)
            },
            placeHolder = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email
        )

        DefaultTextField(
            value = state.password,
            onValueChange = {
                            loginViewModel.onPasswordInput(it)
            },
            placeHolder = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
            hideText = true
        )

        ErrorMessage(text = state.errorMessage)

        DefaultButton(
            text = stringResource(id = R.string.sign_in),
            onCLick = { loginViewModel.signInUser() })
        
        DefaultButton(
            text = String.format(stringResource(id = R.string.continue_with), "google"),
            onCLick = { })

    }
}