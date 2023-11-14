package com.aladin.framepro.data.repositories

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.FrameDescription


interface FrameDescriptionRepository {

    suspend fun insertFrameDescription(frameDescription: FrameDescription)
    suspend fun registerFrames(registerId: Long) : List<FrameDescription>
}