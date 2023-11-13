package com.aladin.framepro.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.data.models.RegisterEntity


@Dao
interface RegisterDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(registerEntity: RegisterEntity) : Long

    @Query("SELECT * FROM register_table")
    fun getAllRegisters() : LiveData<List<RegisterEntity>>

    @Delete
    fun delete(registerEntity: RegisterEntity)

}