package com.aladin.framepro.domain.register.usecase

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.repository.RegisterRepository
import com.aladin.framepro.domain.usecase.GetRegistersUseCase

class GetRegistersUseCaseImpl(
    private val registerRepository: RegisterRepository
) : GetRegistersUseCase {

    override suspend fun invoke(): LiveData<List<Register>> {
        return registerRepository.getRegisters()
    }
}