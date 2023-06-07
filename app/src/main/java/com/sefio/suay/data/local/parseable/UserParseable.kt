package com.sefio.suay.data.local.parseable

import com.sefio.suay.domain.db_object.UserDBObject
import com.sefio.suay.domain.model.User
import javax.inject.Inject

class UserParseable @Inject constructor() {

    fun to(user:User, logged: Boolean = false): UserDBObject {
        return UserDBObject(
            id = user.id,
            username = user.username,
            logged = logged,
            email = user.email
        )
    }

    fun from(userDBObject: UserDBObject): User {
        return User(
            id = userDBObject.id,
            username = userDBObject.username,
            email = userDBObject.email
        )
    }

}