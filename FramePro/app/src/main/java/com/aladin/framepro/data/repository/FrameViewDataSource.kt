package com.aladin.framepro.data.repository

import androidx.lifecycle.LiveData
import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.domain.model.FrameView


interface FrameViewDataSource {

    suspend fun createFrameView(frameView: FrameView)

    val allCreatedFrameViews : LiveData<List<FrameView>>



}