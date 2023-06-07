package com.sefio.suay.data.local

import com.sefio.suay.data.local.db.SefioDatabase
import com.sefio.suay.data.local.parseable.UserParseable
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val sefioDatabase: SefioDatabase,
    private val userParseable: UserParseable
) {

    fun saveUser(user:User) {
        sefioDatabase.userDao().save(userParseable.to(user, true))
    }

    fun loadIdentification(): String {
        return sefioDatabase.userDao().loadIdentification()
    }

    fun loadUser(): User? {
        val user = sefioDatabase.userDao().loadUser()

        return if (user == null)
            null
        else
            userParseable.from(user)
    }

}