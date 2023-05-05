package com.sefio.suay.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sefio.suay.data.local.db.SefioDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun provideSefioDataBase(@ApplicationContext context: Context): SefioDatabase = Room.databaseBuilder(
        context = context, SefioDatabase::class.java, "sefio_database"
    ).build()
}