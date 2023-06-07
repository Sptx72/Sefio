package com.sefio.suay.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sefio.suay.data.local.db.dao.UserDao
import com.sefio.suay.domain.db_object.UserDBObject

@Database(
    entities = [
        UserDBObject::class
    ],
    version = 2,
    exportSchema = false
)
abstract class SefioDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}