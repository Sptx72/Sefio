package com.sefio.suay.data.remote.helpers

import com.sefio.suay.data.remote.SefioDashBoard
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.JsonObjectWrapper
import javax.inject.Inject

class AuthMapper @Inject constructor(
    private val userMapper: UserMapper
) {

    fun from(jsonObjectWrapper: JsonObjectWrapper): AuthToken {
        return AuthToken(
            token = jsonObjectWrapper.getString(SefioDashBoard.TOKEN),
            nickname = jsonObjectWrapper.getString(SefioDashBoard.NICKNAME),
            user = userMapper.from(jsonObjectWrapper.getJsonObjectWrapper(SefioDashBoard.USER))
        )
    }
}