package com.aladin.framepro.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aladin.framepro.data.db.daos.RegisterDao

@Database(entities = [RegisterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun registerDao(): RegisterDao
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