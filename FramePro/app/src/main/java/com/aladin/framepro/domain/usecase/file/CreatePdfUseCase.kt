package com.aladin.framepro.domain.usecase.file

import android.content.Context
import com.aladin.framepro.domain.model.Register

interface CreatePdfUseCase {

    suspend operator fun invoke(context: Context, register: Register)

}