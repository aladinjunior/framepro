package com.aladin.framepro.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aladin.framepro.domain.model.FrameEntity
import com.aladin.framepro.domain.model.FrameViewEntity

@Dao
interface FrameViewDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(frameView: FrameViewEntity)

//    @Query("SELECT * FROM frame_view_entity_table WHERE id = :id")
//    fun getRegisterFrame(id: Long) : List<FrameEntity>


}