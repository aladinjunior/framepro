package com.aladin.framepro.domain.usecase.register

import com.aladin.framepro.domain.model.Register

interface CreateRegisterUseCase {

    suspend operator fun invoke(register: Register) : Long
}