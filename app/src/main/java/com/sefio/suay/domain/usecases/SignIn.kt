package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.AuthRepository
import javax.inject.Inject

class SignIn @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(email:String, password:String) = authRepository.signIn(email = email, password = password)
}