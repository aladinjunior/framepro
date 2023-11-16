package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aladin.framepro.R
import com.aladin.framepro.data.db.instructions.DbInstBase
import com.aladin.framepro.data.db.instructions.DbInstDataSource
import com.aladin.framepro.data.db.instructions.DbInstructionsImpl
import com.aladin.framepro.databinding.FragmentFrameSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FrameSheet(
    private val name: String,
    private val registerId: Long,
    private val dbInstructions: DbInstBase = DbInstDataSource(
        DbInstructionsImpl()
    )
) :
    BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFrameSheetBinding

    private val frameDescViewModel by lazy {
        ViewModelProvider(requireActivity())[FrameDescriptionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFrameSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()

        frameDescViewModel.saved(false)
        binding.saveBttn.setOnClickListener {
            with(binding) {
                if (width.text?.isNotEmpty() == true && height.text?.isNotEmpty() == true) {
                    dbInstructions.saveOnFrameDb(
                        this@FrameSheet,
                        frameDescViewModel,
                        name,
                        registerId,
                        width.text.toString().toDouble(),
                        height.text.toString().toDouble(),
                        description.text.toString()
                    )
                    frameDescViewModel.saved(true)
                } else {
                    dismiss()
                    showToast(getString(R.string.fields_cant_be_null))
                }

            }

        }


    }


}