package com.aladin.framepro.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.databinding.FragmentFramesBinding
import com.aladin.framepro.util.Navigation
import com.aladin.framepro.extensions.buildFrames
import com.aladin.framepro.viewmodel.AddFrameViewModel
import com.aladin.framepro.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FramesFragment : Fragment(R.layout.fragment_frames) {


    private lateinit var binding: FragmentFramesBinding

    private val args: FramesFragmentArgs by navArgs()

    private lateinit var frameSheet: FrameSheet

    private val addFrameViewModel: AddFrameViewModel by viewModels()

    private val mainActivity = activity as? MainActivity

    private val adapter by lazy {
        FramesAdapter { str ->
            frameSheet = FrameSheet(str, viewModel = addFrameViewModel)
            frameSheet.show(requireActivity().supportFragmentManager, "frameTag")
        }
    }

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFramesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = buildFrames()

        binding.framesRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.framesRv.adapter = adapter
        adapter.setList(list)

        addFrameViewModel.savedOnDb.observe(viewLifecycleOwner) {
            if (it) binding.saveBttn.visibility = View.VISIBLE
        }

        binding.saveBttn.setOnClickListener {

            args.register.frames = frameSheet.list
            registerViewModel.createRegister(args.register)

            Navigation().goToRegisterScreen(this)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity?.isEnabledBottomBar(false)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
   //     mainActivity?.isEnabledBottomBar(true)
        super.onDestroy()
    }
}
