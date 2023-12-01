package com.aladin.framepro.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.db.daos.RegisterDao
import com.aladin.framepro.data.models.FrameEntity
import com.aladin.framepro.data.models.RegisterEntity
import com.aladin.framepro.extensions.Converters

@Database(entities = [RegisterEntity::class, FrameEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun registerDao(): RegisterDao
    abstract fun frameDescriptionDao(): FrameDescriptionDao


}