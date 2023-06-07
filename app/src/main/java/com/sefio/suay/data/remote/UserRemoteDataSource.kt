package com.sefio.suay.data.remote

import com.google.gson.JsonObject
import com.sefio.suay.data.remote.api.UserApi
import com.sefio.suay.data.remote.mapper.UserMapper
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val apiExecutor: ApiExecutor,
    private val userApi: UserApi,
    private val userMapper:UserMapper
) {

    fun signIn(email:String, password:String): User {
        return userMapper.from(userApi.signIn(email = email, password = password))
    }
}