package com.aladin.framepro.ui


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.databinding.FragmentFramesBinding
import com.aladin.framepro.domain.model.initialFrames
import com.aladin.framepro.util.Navigation
import com.aladin.framepro.viewmodel.AddFrameViewModel
import com.aladin.framepro.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FramesFragment : Fragment(R.layout.fragment_frames) {


    private lateinit var binding: FragmentFramesBinding

    private val args: FramesFragmentArgs by navArgs()

    private lateinit var frameSheet: FrameSheet

    private lateinit var createFrameSheet: CreateFrameSheet

    private val addFrameViewModel: AddFrameViewModel by viewModels()

    private var mainActivity: MainActivity? = null

    private lateinit var adapter: FramesAdapter

    private val registerViewModel: RegisterViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFramesBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainActivity = activity as? MainActivity

        mainActivity?.isEnabledBottomBar(false)

        adapter = FramesAdapter(requireContext(), initialFrames(requireContext())) { frameName ->
            frameSheet = FrameSheet(frameName, viewModel = addFrameViewModel)
            frameSheet.show(requireActivity().supportFragmentManager, "frameTag")
        }



        binding.framesRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.framesRv.adapter = adapter


        addFrameViewModel.savedOnDb.observe(viewLifecycleOwner) {
            if (it) binding.saveBttn.visibility = View.VISIBLE
        }



        addFrameViewModel.allCreatedFrame.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }




        binding.createFrame.setOnClickListener {
            createFrameSheet = CreateFrameSheet(addFrameViewModel)
            createFrameSheet.show(requireActivity().supportFragmentManager, "frameTag")
        }

        binding.saveBttn.setOnClickListener {

            args.register.frames = frameSheet.list
            registerViewModel.createRegister(args.register)

            Navigation().goToRegisterScreen(this)

        }
    }


    override fun onDestroy() {
        mainActivity?.isEnabledBottomBar(true)
        super.onDestroy()
    }
}
