package com.aladin.framepro.domain.register.usecase

import com.aladin.framepro.data.models.Register

interface CreateRegisterUseCase {

    suspend operator fun invoke(register: Register) : Long
}