package com.aladin.framepro.data.repository

import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.repositories.FrameDescriptionDataSource

class FrameRepository(private val dataSource: FrameDescriptionDataSource) {

    suspend fun createFrame(frameDescription: FrameDescription)
    = dataSource.createFrame(frameDescription)

}