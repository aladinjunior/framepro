package com.aladin.framepro.data.repository

import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.domain.model.FrameView


interface FrameViewDataSource {

    suspend fun createFrameView(frameView: FrameView)
    suspend fun registerFrames(registerId: Long) : List<Frame>

}