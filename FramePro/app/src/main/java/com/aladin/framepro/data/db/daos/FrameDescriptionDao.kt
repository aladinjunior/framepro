package com.aladin.framepro.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aladin.framepro.data.models.FrameDescriptionEntity

@Dao
interface FrameDescriptionDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameDescriptionEntity: FrameDescriptionEntity)
}