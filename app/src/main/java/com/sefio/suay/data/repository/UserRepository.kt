package com.sefio.suay.data.repository

import com.sefio.suay.data.local.UserLocalDataSource
import com.sefio.suay.data.remote.UserRemoteDataSource
import com.sefio.suay.domain.model.Response
import com.sefio.suay.domain.model.User
import com.sefio.suay.helpers.AppTextUtils
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) {

    fun signIn(email:String, password:String): Response<Nothing> {
        return try {
            var user = loadLocalUser()

            if (user == null)
                user = userRemoteDataSource.signIn(email = email, password = password)

            saveUser(user = user)

            Response.EmptySuccess
        } catch (e:Exception) {
            Response.Failure(e)
        }
    }

    fun saveUser(user:User) {
        userLocalDataSource.saveUser(user)
    }

    fun loadIdentification(): String {
        return userLocalDataSource.loadIdentification()
    }

    fun loadLocalUser(): User? {
        return userLocalDataSource.loadUser()
    }

}