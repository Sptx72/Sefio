package com.sefio.suay.data.repository

import com.sefio.suay.data.local.AuthLocalDataSource
import com.sefio.suay.data.remote.AuthRemoteDataSource
import com.sefio.suay.domain.model.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) {

    fun isLogged(): Response<Boolean> {
        return authLocalDataSource.isLogged()
    }

    fun signIn(email:String, password:String): Response<Nothing> {
        return try {
            val id = authRemoteDataSource.signIn(email = email, password = password)
            authLocalDataSource.saveIdentification(id)
            Response.EmptySuccess
        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}