package com.sefio.suay.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sefio.suay.data.local.db.ColumnName
import com.sefio.suay.data.local.db.TableName
import com.sefio.suay.domain.db_object.UserDBObject

@Dao
abstract class UserDao : BasicDao<UserDBObject>() {

    @Query("SELECT " + ColumnName.ID + " FROM " + TableName.USER_TABLE + " WHERE " + ColumnName.LOGGED + " = 1")
    abstract fun loadIdentification(): String

    @Query("SELECT * FROM " + TableName.USER_TABLE + " WHERE " + ColumnName.LOGGED + " = 1")
    abstract fun loadUser(): UserDBObject?
}