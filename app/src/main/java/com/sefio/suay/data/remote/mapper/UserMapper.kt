package com.sefio.suay.data.remote.mapper

import com.sefio.suay.data.remote.SefioParams
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun from(jsonObjectWrapper: JsonObjectWrapper): User {
        return User(
            id = jsonObjectWrapper.getString(SefioParams.ID),
            email = jsonObjectWrapper.getString(SefioParams.EMAIL),
            username = jsonObjectWrapper.getString(SefioParams.USERNAME)
        )
    }

}