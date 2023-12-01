package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.databinding.FragmentFrameSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodel.AddFrameViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FrameSheet(
    private val name: String,
    val list: MutableList<Frame> = mutableListOf(),
    private val viewModel: AddFrameViewModel
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFrameSheetBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFrameSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()

        viewModel.saved(false)


        binding.saveBttn.setOnClickListener {
            with(binding) {
                with(viewModel){
                    if (emptyFieldError(width.text, height.text, description.text)) {

                        val frame = buildFrame(
                            name,
                            width.text.toString().toDouble(),
                            height.text.toString().toDouble(),
                            description.text.toString()
                        )

                        addFrameToList(frame)

                        listOfFramesLiveData.observe(viewLifecycleOwner) { frames ->
                            list.clear()
                            list.addAll(frames)
                        }

                        saved(true)
                        dismiss()

                    } else {
                        dismiss()
                        showToast(getString(R.string.fields_cant_be_null))

                    }
                    }
                }



            }

        }


    }

