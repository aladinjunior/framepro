package com.aladin.framepro.data.repositories

import com.aladin.framepro.data.models.FrameDescription


interface FrameDescriptionRepository {

    suspend fun insertFrameDescription(frameDescription: FrameDescription)
}