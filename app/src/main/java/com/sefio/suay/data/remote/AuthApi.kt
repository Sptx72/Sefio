package com.sefio.suay.data.remote

import com.sefio.suay.data.remote.back.BackApi
import com.sefio.suay.data.remote.back.Endpoints
import com.sefio.suay.data.remote.back.services.AuthService
import com.sefio.suay.data.remote.helpers.AuthMapper
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.JsonObjectWrapper
import retrofit2.await
import javax.inject.Inject

class AuthApi @Inject constructor(
    private val authMapper: AuthMapper,
    backApi: BackApi
) {

    private val authService = backApi.create(AuthService::class.java)

    suspend fun signIn(email:String, password:String): AuthToken {
        return authMapper.from(JsonObjectWrapper(authService.signIn(email = email, password = password).await()))
    }
}