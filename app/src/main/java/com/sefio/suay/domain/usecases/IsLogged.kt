package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.AuthRepository
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class IsLogged @Inject constructor(
    private val authRepository: AuthRepository
){

    operator fun invoke(): Response<Boolean> = authRepository.isLogged()
}