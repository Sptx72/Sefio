package com.sefio.suay.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.R
import com.sefio.suay.ui.components.AppName
import com.sefio.suay.ui.components.NormalText
import com.sefio.suay.ui.screens.login.components.Login
import com.sefio.suay.ui.screens.login.components.LoginForm

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.padding(30.dp),
        topBar = {
            AppName()
        },
        content = {
            LoginForm(loginViewModel)
        },
        bottomBar = {
            NormalText(
                text = stringResource(id = R.string.not_account_register_here)
            )
        }
    )

    Login(navHostController = navHostController)
}