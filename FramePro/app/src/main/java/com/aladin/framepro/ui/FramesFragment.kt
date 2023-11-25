package com.aladin.framepro.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.data.db.instructions.DbInstBase
import com.aladin.framepro.data.db.instructions.DbInstDataSource
import com.aladin.framepro.data.db.instructions.DbInstructionsImpl
import com.aladin.framepro.databinding.FragmentFramesBinding
import com.aladin.framepro.extensions.buildFrames
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.aladin.framepro.viewmodels.RegisterViewModel

@Suppress("DEPRECATION")
class FramesFragment : Fragment(R.layout.fragment_frames) {


    private lateinit var dbInstructions: DbInstBase

    private lateinit var binding: FragmentFramesBinding

    private val args: FramesFragmentArgs by navArgs()

    private lateinit var frameSheet: FrameSheet

    private val frameDescViewModel by lazy {
        ViewModelProvider(requireActivity())[FrameDescriptionViewModel::class.java]
    }

    private val adapter by lazy {
        FramesAdapter { str ->
            frameSheet = FrameSheet(str)
            frameSheet.show(requireActivity().supportFragmentManager, "frameTag")
        }
    }

    private val registerViewModel by lazy {
        ViewModelProvider(requireActivity())[RegisterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFramesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = buildFrames()
        dbInstructions = DbInstDataSource(DbInstructionsImpl())

        val mainActivity = activity as? MainActivity
        mainActivity?.disableBottomBar()


        binding.framesRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.framesRv.adapter = adapter
        adapter.setList(list)

        frameDescViewModel.savedOnDb.observe(viewLifecycleOwner) { boolean ->
            if (boolean) binding.saveBttn.visibility = View.VISIBLE
        }

        binding.saveBttn.setOnClickListener {

            if (args.register.frames.isNotEmpty()) {
                dbInstructions.saveOnRegisterDb(
                    frameSheet,
                    registerViewModel,
                    args.register.name,
                    args.register.address,
                    frameSheet.list
                )
            }

        }


    }
}
