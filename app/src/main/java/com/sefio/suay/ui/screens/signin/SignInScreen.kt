package com.sefio.suay.ui.screens.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sefio.suay.R
import com.sefio.suay.di.App
import com.sefio.suay.domain.model.Response
import com.sefio.suay.helpers.AppTextUtils
import com.sefio.suay.ui.components.*
import com.sefio.suay.ui.navigation.AppScreen

@Composable
fun SignInScreen(
    navHostController: NavHostController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    SignInForm(viewModel = viewModel, navHostController = navHostController)

    val signInFLow = viewModel.signInFlow.collectAsState()
    var shouldShowWaitScreen by remember {
        mutableStateOf(false)
    }
    var errorMsg by remember {
        mutableStateOf("")
    }

    LaunchedEffect(signInFLow.value) {
        when (val it = signInFLow.value) {
            is Response.Loading -> {
                shouldShowWaitScreen = true
            }

            is Response.Success -> {
                navHostController.navigate(AppScreen.Home.route)
            }

            is Response.Failure -> {
                errorMsg = it.e.message ?: "No description error"
            }

            else -> {}
        }
    }

    if (shouldShowWaitScreen) WaitScreen()
    else if (!AppTextUtils.isEmpty(errorMsg)) ErrorScreen(text = errorMsg)
}

@Composable
fun SignInForm(
    viewModel: SignInViewModel,
    navHostController: NavHostController,
    error:String = ""
) {
    println("sign in form")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = stringResource(id = R.string.sign_in))

        DefaultTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            placeHolder = stringResource(id = R.string.email))

        DefaultTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            placeHolder = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
            hideText = true,
            errorMsg = error)

        DefaultButton(
            text = "INICIA SESION",
            onCLick = { viewModel.signUser() })

        SmallText(
            text = "No estas registrado? Crea tu cuenta aquí.",
            onCLick = {
                navHostController.navigate(AppScreen.SignUp.route)
            })


    }
}