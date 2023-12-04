package com.aladin.framepro.data.repository

import com.aladin.framepro.data.db.daos.FrameViewDao
import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.domain.model.FrameView
import com.aladin.framepro.extensions.toFrameDescription
import com.aladin.framepro.extensions.toFrameViewEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomFrameViewDataSource @Inject constructor(
    private val frameDao: FrameViewDao
) : FrameViewDataSource {

    override suspend fun createFrameView(frameView: FrameView)  {
        withContext(Dispatchers.IO){
            val frameViewEntity = frameView.toFrameViewEntity()
            frameDao.insert(frameViewEntity)
        }
    }

    override suspend fun registerFrames(registerId: Long) : List<Frame> {
        return emptyList()
//        return frameDao.getRegisterFrame(registerId).toFrameDescription()
    }

}