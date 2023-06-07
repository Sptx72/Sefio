package com.sefio.suay.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
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
    fun provideSefioDatabase(@ApplicationContext context: Context): SefioDatabase = Room.databaseBuilder(
        context, SefioDatabase::class.java, "sefio_db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideStorage(): StorageReference = FirebaseStorage.getInstance().reference

}