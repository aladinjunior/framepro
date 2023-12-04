package com.aladin.framepro.domain.usecase.register

import com.aladin.framepro.domain.model.Register
import com.aladin.framepro.data.repository.RegisterRepository
import javax.inject.Inject

class CreateRegisterUseCaseImpl @Inject constructor(
    private val registerRepository: RegisterRepository
) : CreateRegisterUseCase {

    override suspend fun invoke(register: Register): Long {
        return registerRepository.createRegister(register)
    }
}