package com.aladin.framepro.data.repository

import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.extensions.toFrameDescription
import com.aladin.framepro.extensions.toFrameDescriptionEntity
import javax.inject.Inject

class RoomFrameDescriptionDataSource @Inject constructor(
    private val frameDao: FrameDescriptionDao
) : FrameDescriptionDataSource {

    override suspend fun createFrame(frame: Frame)  {
        val frameDescriptionEntity = frame.toFrameDescriptionEntity()
        frameDao.insert(frameDescriptionEntity)
    }

    override suspend fun registerFrames(registerId: Long) : List<Frame> {
        return frameDao.getRegisterFrame(registerId).toFrameDescription()
    }

}