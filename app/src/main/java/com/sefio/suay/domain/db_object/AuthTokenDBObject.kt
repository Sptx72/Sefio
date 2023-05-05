package com.sefio.suay.domain.db_object

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.sefio.suay.data.local.db.ColumnName
import com.sefio.suay.data.local.db.TableName

@Entity(tableName = TableName.AUTH, primaryKeys = [ColumnName.NICKNAME])
data class AuthTokenDBObject(
    @ColumnInfo(name = ColumnName.NICKNAME) val nickname:String,
    @ColumnInfo(name = ColumnName.TOKEN) val token:String
    )
