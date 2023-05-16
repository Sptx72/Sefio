package com.sefio.suay.ui.screens.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.domain.model.Response
import com.sefio.suay.ui.components.WaitScreen
import com.sefio.suay.ui.navigation.Graph
import com.sefio.suay.ui.screens.login.LoginViewModel

@Composable
fun Login(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    when(val loginResponse = loginViewModel.loginResponse) {
        is Response.Loading -> {
            WaitScreen()
        }

        is Response.Failure -> {
            if (loginResponse.e.message != null)
                loginViewModel.onError(loginResponse.e.message!!)
        }

        is Response.EmptySuccess -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(Graph.HOME)
            }
        }

        else -> {}
    }


}