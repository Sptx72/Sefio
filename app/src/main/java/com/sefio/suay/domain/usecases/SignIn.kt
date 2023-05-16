package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.AuthRepository
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class SignIn @Inject constructor(
    private val authRepository: AuthRepository
) {

    operator fun invoke(email:String, password:String): Response<Nothing> = authRepository.signIn(email = email, password = password)
}