package com.aladin.framepro.domain.usecase

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.Register

interface GetRegistersUseCase {

    suspend operator fun invoke() : LiveData<List<Register>>

}