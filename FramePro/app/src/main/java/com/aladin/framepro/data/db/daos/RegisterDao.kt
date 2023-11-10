package com.aladin.framepro.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface RegisterDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(registerEntity: com.aladin.framepro.data.db.RegisterEntity)

}