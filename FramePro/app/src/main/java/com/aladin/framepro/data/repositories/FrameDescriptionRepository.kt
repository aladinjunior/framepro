package com.aladin.framepro.data.repositories

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register


interface FrameDescriptionRepository {

    suspend fun insertFrameDescription(frameDescription: FrameDescription)
    suspend fun registerFrames(registerId: Long) : List<FrameDescription>
//    suspend fun getFramesOfRegister(registerId: Long) : List<FrameDescription>

//    suspend fun getFramesOfRegister(id: Long) : List<FrameDescription>
}