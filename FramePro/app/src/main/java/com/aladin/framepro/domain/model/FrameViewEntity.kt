package com.aladin.framepro.domain.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frame_view_entity_table")
data class FrameViewEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imgCover: Uri,
    val name: String,
    val material: String,
)
