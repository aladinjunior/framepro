package com.aladin.framepro.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.data.models.FrameDescriptionEntity

@Dao
interface FrameDescriptionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameDescriptionEntity: FrameDescriptionEntity)

    @Query("SELECT * FROM frame_description_table WHERE registerId = :registerId")
    fun getRegisterFrame(registerId: Long) : List<FrameDescriptionEntity>
}