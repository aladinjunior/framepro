package com.aladin.framepro.domain.register.usecase

import com.aladin.framepro.data.models.Register

interface DeleteRegisterUseCase {

    suspend operator fun invoke(register: Register)
}