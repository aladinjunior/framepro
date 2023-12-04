package com.aladin.framepro.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.aladin.framepro.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideAppDataBase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "framepro_db"
    ).build()

    @Provides
    @Singleton
    fun provideRegisterDao(
        db: AppDatabase
    ) = db.registerDao()

    @Singleton
    @Provides
    fun provideFrameDescriptionDao(
        db: AppDatabase
    ) = db.frameViewDao()

}