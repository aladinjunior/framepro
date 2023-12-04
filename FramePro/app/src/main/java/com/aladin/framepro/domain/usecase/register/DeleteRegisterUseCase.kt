package com.aladin.framepro.domain.usecase.register

import com.aladin.framepro.domain.model.Register

interface DeleteRegisterUseCase {

    suspend operator fun invoke(register: Register)
}