package com.aladin.framepro.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.domain.model.FrameEntity

@Dao
interface FrameDescriptionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameEntity: FrameEntity)

    @Query("SELECT * FROM frame_description_table WHERE id = :id")
    fun getRegisterFrame(id: Long) : List<FrameEntity>


}