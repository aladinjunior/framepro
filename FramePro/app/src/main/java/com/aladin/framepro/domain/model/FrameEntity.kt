package com.aladin.framepro.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "frame_description_table")
data class FrameEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var registerId: Long,
    var name: String,
    var width: Double,
    var height: Double,
    var description: String

)
