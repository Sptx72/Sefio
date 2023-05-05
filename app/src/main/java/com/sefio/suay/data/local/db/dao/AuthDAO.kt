package com.sefio.suay.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sefio.suay.data.local.db.ColumnName
import com.sefio.suay.data.local.db.TableName
import com.sefio.suay.domain.db_object.AuthTokenDBObject

@Dao
abstract class AuthDAO : BasicDAO<AuthTokenDBObject>(){

    @Query("SELECT " + ColumnName.NICKNAME + " FROM " + TableName.AUTH)
    abstract fun fetchNickName():String

    @Query("SELECT " + ColumnName.TOKEN + " FROM " + TableName.AUTH)
    abstract  fun fetchToken(): String

    @Query("SELECT * FROM " + TableName.AUTH)
    abstract fun fetchAuthToken(): AuthTokenDBObject

}