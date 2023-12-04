package com.aladin.framepro.di

import com.aladin.framepro.data.repository.FrameViewDataSource
import com.aladin.framepro.data.repository.RegisterDataSource
import com.aladin.framepro.data.repository.RoomFrameViewDataSource
import com.aladin.framepro.data.repository.RoomRegisterDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DataModule {

    @Binds
    fun createRegisterDataSource(dataSource: RoomRegisterDataSource) : RegisterDataSource

    @Binds
    fun createFrameDescriptionDataSource(dataSource: RoomFrameViewDataSource) : FrameViewDataSource
}