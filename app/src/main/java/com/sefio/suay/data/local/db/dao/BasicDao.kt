package com.sefio.suay.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
abstract class BasicDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(t: T)

    @Insert
    abstract fun saveAll(tList: List<T>)
}