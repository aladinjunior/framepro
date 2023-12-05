package com.aladin.framepro.data.repository

import com.aladin.framepro.domain.model.FrameView
import javax.inject.Inject

class FrameViewRepository @Inject constructor(
    private val dataSource: FrameViewDataSource
) {

    suspend fun createFrame(frameView: FrameView)
    = dataSource.createFrameView(frameView)


}