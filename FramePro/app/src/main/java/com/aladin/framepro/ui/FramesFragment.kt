package com.aladin.framepro.ui



import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.databinding.FragmentFramesBinding
import com.aladin.framepro.extensions.buildFrames

@Suppress("DEPRECATION")
class FramesFragment : Fragment(R.layout.fragment_frames) {


    private lateinit var binding: FragmentFramesBinding

    private val args: FramesFragmentArgs by navArgs()


    private val adapter by lazy {
        FramesAdapter { str ->
            FrameSheet(str, args.id).show(requireActivity().supportFragmentManager, "frameTag")
        }
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

        binding.framesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.framesRv.adapter = adapter
        adapter.setList(list)

        binding.previousName.text = args.name
        binding.previousAddress.text = args.address

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                findNavController().popBackStack()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    }
