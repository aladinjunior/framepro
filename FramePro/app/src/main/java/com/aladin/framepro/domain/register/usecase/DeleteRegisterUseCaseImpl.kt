package com.aladin.framepro.domain.register.usecase

import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.repository.RegisterRepository

class DeleteRegisterUseCaseImpl(
    private val registerRepository: RegisterRepository
): DeleteRegisterUseCase{

    override suspend fun invoke(register: Register) {
        registerRepository.deleteRegister(register)
    }
}