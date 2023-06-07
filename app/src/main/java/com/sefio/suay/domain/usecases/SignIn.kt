package com.sefio.suay.domain.usecases

import com.sefio.suay.data.repository.UserRepository
import javax.inject.Inject

class SignIn @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(email:String, password:String) = userRepository.signIn(email = email, password = password)
}