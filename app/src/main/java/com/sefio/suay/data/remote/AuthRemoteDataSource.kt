package com.sefio.suay.data.remote

import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {

    fun signIn(email:String, password:String): String {
        return authApi.signIn(email = email, password = password)
    }

}