package com.sefio.suay.domain.db_object

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sefio.suay.data.local.db.ColumnName
import com.sefio.suay.data.local.db.TableName

@Entity(tableName = TableName.USER_TABLE)
data class UserDBObject(
    @PrimaryKey @ColumnInfo(name = ColumnName.ID)
    val id: String,
    @ColumnInfo(name = ColumnName.USERNAME)
    val username:String,
    @ColumnInfo(name = ColumnName.LOGGED)
    val logged:Boolean,
    @ColumnInfo(name = ColumnName.EMAIL)
    val email:String
)
