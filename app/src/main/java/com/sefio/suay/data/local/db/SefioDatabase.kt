package com.sefio.suay.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sefio.suay.data.local.db.dao.AuthDAO
import com.sefio.suay.domain.db_object.AuthTokenDBObject

@Database(
    entities = [
        AuthTokenDBObject::class
               ],
    exportSchema = false,
    version = 1
)
abstract class SefioDatabase : RoomDatabase() {
    abstract fun getAuthDAO(): AuthDAO
}