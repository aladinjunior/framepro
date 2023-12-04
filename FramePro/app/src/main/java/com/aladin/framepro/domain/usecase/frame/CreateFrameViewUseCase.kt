package com.aladin.framepro.domain.usecase.frame

import com.aladin.framepro.domain.model.FrameView

interface CreateFrameViewUseCase {
    suspend operator fun invoke(frameView: FrameView)
}