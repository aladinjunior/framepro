package com.aladin.framepro.data.repository

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.db.daos.FrameViewDao
import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.domain.model.FrameView
import com.aladin.framepro.extensions.map
import com.aladin.framepro.extensions.toFrameView
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

    override val allCreatedFrameViews: LiveData<List<FrameView>> = frameDao.getAllCreatedFrames().map { listOfFrameView ->
        listOfFrameView.map { frameViewEntity ->
            frameViewEntity.toFrameView()
        }

    }


}