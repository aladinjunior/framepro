package com.aladin.framepro.domain.usecase.frame

import com.aladin.framepro.data.repository.FrameViewRepository
import com.aladin.framepro.domain.model.FrameView
import javax.inject.Inject

class CreateFrameViewUseCaseImpl @Inject constructor(
    private val frameViewRepository: FrameViewRepository
)
    : CreateFrameViewUseCase {
    override suspend fun invoke(frameView: FrameView) {
        frameViewRepository.createFrame(frameView)
    }
}