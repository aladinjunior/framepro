package com.aladin.framepro.di

import com.aladin.framepro.domain.register.usecase.CreateRegisterUseCase
import com.aladin.framepro.domain.register.usecase.CreateRegisterUseCaseImpl
import com.aladin.framepro.domain.register.usecase.DeleteRegisterUseCase
import com.aladin.framepro.domain.register.usecase.DeleteRegisterUseCaseImpl
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

//    fun createFrameUseCase(useCase: CreateFrameUseCaseImpl) : CreateFrameUseCase


}