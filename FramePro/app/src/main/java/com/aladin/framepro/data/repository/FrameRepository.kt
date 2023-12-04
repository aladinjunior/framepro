package com.aladin.framepro.data.repository

import com.aladin.framepro.domain.model.Frame
import javax.inject.Inject

class FrameRepository @Inject constructor(
    private val dataSource: FrameDescriptionDataSource
) {

    suspend fun createFrame(frame: Frame)
    = dataSource.createFrame(frame)

}