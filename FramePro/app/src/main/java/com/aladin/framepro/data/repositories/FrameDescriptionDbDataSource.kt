package com.aladin.framepro.data.repositories

import com.aladin.framepro.data.db.daos.FrameDescriptionDao
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
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

    override suspend fun getFramesOfRegister(register: Register): List<FrameDescription> {
        TODO("Not yet implemented")
    }

    //    override suspend fun getFramesOfRegister(id: Long): List<FrameDescription> {
//        return frameDao.getFramesOfRegister(id).toFrameDescription()
//    }
}