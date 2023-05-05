package com.sefio.suay.data.local.db.dao

import androidx.room.*


@Dao
abstract class BasicDAO <T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(objects: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(obj: T)

    @Delete
    abstract fun delete(objects: List<T>)

    @Delete
    abstract fun delete(obj: T)

    @Update
    abstract fun update(objects: List<T>)

    @Update
    abstract fun update(obj: T)
}