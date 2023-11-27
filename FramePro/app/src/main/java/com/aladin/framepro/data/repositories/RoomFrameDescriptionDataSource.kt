package com.aladin.framepro.data.repositories

import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.extensions.toFrameDescription
import com.aladin.framepro.extensions.toFrameDescriptionEntity

class RoomFrameDescriptionDataSource(private val frameDao: FrameDescriptionDao) : FrameDescriptionDataSource {

    override suspend fun createFrame(frameDescription: FrameDescription) {
        val frameDescriptionEntity = frameDescription.toFrameDescriptionEntity()
        frameDao.insert(frameDescriptionEntity)
    }

    override suspend fun registerFrames(registerId: Long) : List<FrameDescription> {
        return frameDao.getRegisterFrame(registerId).toFrameDescription()
    }

//    override suspend fun getFramesOfRegister(registerId: Long): List<FrameDescription> {
//       return frameDao.getRegisterFrame(registerId).toFrameDescription()
//    }

    //    override suspend fun getFramesOfRegister(id: Long): List<FrameDescription> {
//        return frameDao.getFramesOfRegister(id).toFrameDescription()
//    }
}