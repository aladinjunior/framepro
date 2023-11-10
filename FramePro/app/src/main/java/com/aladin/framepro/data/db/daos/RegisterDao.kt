package com.aladin.framepro.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.data.db.RegisterEntity


@Dao
interface RegisterDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(registerEntity: RegisterEntity)

    @Query("SELECT * FROM register_table")
    fun getAllRegisters() : LiveData<List<RegisterEntity>>

}