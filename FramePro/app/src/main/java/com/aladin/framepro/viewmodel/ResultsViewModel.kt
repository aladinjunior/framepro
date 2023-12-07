package com.aladin.framepro.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.domain.model.Register
import com.aladin.framepro.domain.usecase.file.CreatePdfUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ResultsViewModel @Inject constructor(
    application: Application,
    private val createPdfUseCase: CreatePdfUseCase
) : AndroidViewModel(application) {

     fun createPdf(context: Context, register: Register) = viewModelScope.launch(Dispatchers.IO) {
        createPdfUseCase(context, register)
    }





}