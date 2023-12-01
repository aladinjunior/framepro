package com.aladin.framepro.data.repository

import com.aladin.framepro.data.models.Frame


interface FrameDescriptionDataSource {

    suspend fun createFrame(frame: Frame)
    suspend fun registerFrames(registerId: Long) : List<Frame>

}