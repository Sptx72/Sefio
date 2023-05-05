package com.sefio.suay.data.remote.helpers

import com.sefio.suay.domain.db_object.AuthTokenDBObject
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class AuthParseable @Inject constructor() {

    fun to(authToken: AuthToken): AuthTokenDBObject {
        return AuthTokenDBObject(nickname = authToken.nickname, token = authToken.token)
    }

    fun from(authTokenDBObject: AuthTokenDBObject): AuthToken {
        return AuthToken(nickname = authTokenDBObject.nickname, token = authTokenDBObject.token, user = null)
    }
}