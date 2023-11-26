package com.aladin.framepro.domain.usecase

import com.aladin.framepro.data.models.Register

interface CreateRegisterUseCase {

    suspend operator fun invoke() : Register
}