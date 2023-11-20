package com.aladin.framepro.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.data.models.FrameDescriptionEntity
import com.aladin.framepro.data.models.Register

@Dao
interface FrameDescriptionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameDescriptionEntity: FrameDescriptionEntity)

    @Query("SELECT * FROM frame_description_table WHERE id = :id")
    fun getRegisterFrame(id: Long) : List<FrameDescriptionEntity>

//    @Query("SELECT frames FROM register_table WHERE id = :id")
//    fun getFramesOfRegister(register: Register) : List<FrameDescriptionEntity>
}