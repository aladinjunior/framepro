package com.aladin.framepro.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.domain.model.FrameViewEntity

@Dao
interface FrameViewDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameView: FrameViewEntity)

    @Query("SELECT * FROM frame_view_entity_table")
    fun getAllCreatedFrames() : LiveData<List<FrameViewEntity>>




}