package com.aladin.framepro.domain.usecase

import com.aladin.framepro.data.models.FrameDescription

interface CreateFrameUseCase {

    suspend operator fun invoke() : FrameDescription
}