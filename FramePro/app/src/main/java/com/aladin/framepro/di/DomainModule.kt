package com.aladin.framepro.di

import com.aladin.framepro.domain.usecase.frame.CreateFrameViewUseCase
import com.aladin.framepro.domain.usecase.frame.CreateFrameViewUseCaseImpl
import com.aladin.framepro.domain.usecase.register.CreateRegisterUseCase
import com.aladin.framepro.domain.usecase.register.CreateRegisterUseCaseImpl
import com.aladin.framepro.domain.usecase.register.DeleteRegisterUseCase
import com.aladin.framepro.domain.usecase.register.DeleteRegisterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun createRegisterUseCase(useCase: CreateRegisterUseCaseImpl) : CreateRegisterUseCase

    @Binds
    fun deleteRegisterUseCase(useCase: DeleteRegisterUseCaseImpl) : DeleteRegisterUseCase

    @Binds
    fun createFrameViewUseCase(useCase: CreateFrameViewUseCaseImpl) : CreateFrameViewUseCase




}