package com.aladin.framepro.data.repositories

import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.extensions.toFrameDescription
import com.aladin.framepro.extensions.toFrameDescriptionEntity

class FrameDescriptionDbDataSource(private val frameDao: FrameDescriptionDao) : FrameDescriptionRepository {

    override suspend fun insertFrameDescription(frameDescription: FrameDescription) {
        val frameDescriptionEntity = frameDescription.toFrameDescriptionEntity()
        frameDao.insert(frameDescriptionEntity)
    }

    override suspend fun registerFrames(registerId: Long) : List<FrameDescription> {
        return frameDao.getRegisterFrame(registerId).toFrameDescription()
    }

}