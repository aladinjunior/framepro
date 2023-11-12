package com.aladin.framepro.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.db.daos.RegisterDao
import com.aladin.framepro.data.models.FrameDescriptionEntity
import com.aladin.framepro.data.models.RegisterEntity

@Database(entities = [RegisterEntity::class, FrameDescriptionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun registerDao(): RegisterDao
    abstract fun frameDescriptionDao(): FrameDescriptionDao
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "framepro_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}