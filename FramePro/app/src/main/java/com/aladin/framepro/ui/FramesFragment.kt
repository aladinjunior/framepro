package com.aladin.framepro.ui



import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
import com.aladin.framepro.extensions.Navigation
import com.aladin.framepro.extensions.buildFrames
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.aladin.framepro.viewmodels.RegisterViewModel

@Suppress("DEPRECATION")
class FramesFragment : Fragment(R.layout.fragment_frames) {



    private lateinit var dbInstructions: DbInstBase

    private lateinit var binding: FragmentFramesBinding

    private lateinit var menuItem: MenuItem

    private val navigation =  Navigation()

    private val args: FramesFragmentArgs by navArgs()

    private lateinit var frameSheet: FrameSheet

    private val frameDescViewModel by lazy {
        ViewModelProvider(requireActivity())[FrameDescriptionViewModel::class.java]
    }

    private val adapter by lazy {
        FramesAdapter { str ->
            frameSheet = FrameSheet(str, args.register.frames.toMutableList())
            frameSheet.show(requireActivity().supportFragmentManager, "frameTag")
        }
    }

    private val registerViewModel by lazy {
        ViewModelProvider(requireActivity())[RegisterViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFramesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = buildFrames()
        dbInstructions = DbInstDataSource(DbInstructionsImpl())


        binding.framesRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.framesRv.adapter = adapter
        adapter.setList(list)

        binding.previousName.text = args.register.name
        binding.previousAddress.text = args.register.address

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        menuItem = menu.findItem(R.id.check)
        menuItem.isVisible = false
        frameDescViewModel.savedOnDb.observe(viewLifecycleOwner){boolean ->
            if(boolean) menuItem.isVisible = true
        }
        super.onCreateOptionsMenu(menu, inflater)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {

                dbInstructions.saveOnRegisterDb(frameSheet, registerViewModel, args.register.name, args.register.address, frameSheet.list)
                frameDescViewModel.clearFrameDescList()


                navigation.goToRegisterScreen(this@FramesFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    }
