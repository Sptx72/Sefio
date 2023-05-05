package com.sefio.suay.data.remote.helpers

import com.sefio.suay.data.remote.SefioDashBoard
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun from(jsonObjectWrapper: JsonObjectWrapper): User {
        return User(
            nickname = jsonObjectWrapper.getString(SefioDashBoard.NICKNAME),
            id = jsonObjectWrapper.getString(SefioDashBoard.ID),
            email = jsonObjectWrapper.getString(SefioDashBoard.EMAIL)
        )
    }
}