package com.aladin.framepro.domain.usecase.register

import com.aladin.framepro.domain.model.Register
import com.aladin.framepro.data.repository.RegisterRepository
import javax.inject.Inject

class DeleteRegisterUseCaseImpl @Inject constructor(
    private val registerRepository: RegisterRepository
): DeleteRegisterUseCase {

    override suspend fun invoke(register: Register) {
        registerRepository.deleteRegister(register)
    }
}