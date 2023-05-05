package com.sefio.suay.data.repository

import com.sefio.suay.data.local.AuthLocalDataSource
import com.sefio.suay.data.remote.AuthRemoteDataSource
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) {

    fun isLogged(): Response<Boolean> {
        return authLocalDataSource.isLogged()
    }

    suspend fun signIn(email:String, password:String): Response<User> {
        /*return try {
            val authToken = authRemoteDataSource.signIn(email = email, password = password)
            val user = authToken.user

            Response.Success(user)
        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }*/
        val user = User(id = password, nickname = "Marco Andres Moncada", email = email)
        val authToken = AuthToken(nickname = user.nickname, token = "asdfasdf12341234", user = user)

        authLocalDataSource.saveToken(authToken)

        return Response.Success(user)
    }

    fun fetchAuthToken(): AuthToken {
        return authLocalDataSource.fetchAuthToken()
    }

}