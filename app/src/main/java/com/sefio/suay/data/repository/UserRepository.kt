package com.sefio.suay.data.repository

import com.sefio.suay.data.local.UserLocalDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
){

    suspend fun fetchUser() {

    }

}