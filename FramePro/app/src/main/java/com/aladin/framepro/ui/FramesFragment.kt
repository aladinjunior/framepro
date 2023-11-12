package com.aladin.framepro.ui


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.databinding.FragmentFramesBinding
import com.aladin.framepro.databinding.FramesListItemBinding
import com.aladin.framepro.extensions.buildFrames

class FramesFragment() : Fragment(R.layout.fragment_frames) {



    private lateinit var binding: FragmentFramesBinding
    private var frameBinding: FramesListItemBinding? = null



    private val adapter by lazy {
        FramesAdapter { str ->
            FrameSheet(str, 1).show(requireActivity().supportFragmentManager, "frameTag")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFramesBinding.inflate(inflater, container, false)
        frameBinding = FramesListItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = buildFrames()


        binding.framesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.framesRv.adapter = adapter
        adapter.setList(list)

    }




}