package com.sefio.suay.data.remote

import com.sefio.suay.domain.model.AuthToken
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {

    suspend fun signIn(email:String, password:String): AuthToken {
        return authApi.signIn(email = email, password = password)
    }
}