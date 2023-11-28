package com.aladin.framepro.domain.register.usecase

import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.repository.RegisterRepository
import javax.inject.Inject

class CreateRegisterUseCaseImpl @Inject constructor(
    private val registerRepository: RegisterRepository
) : CreateRegisterUseCase {

    override suspend fun invoke(register: Register): Long {
        return registerRepository.createRegister(register)
    }
}