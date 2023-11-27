package com.aladin.framepro.data.repositories

import com.aladin.framepro.data.models.FrameDescription


interface FrameDescriptionDataSource {

    suspend fun createFrame(frameDescription: FrameDescription)
    suspend fun registerFrames(registerId: Long) : List<FrameDescription>

}