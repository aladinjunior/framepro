package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.adapters.SwipeRegister
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentRegisterBinding
import com.aladin.framepro.viewmodels.RegisterViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    private val registerViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[RegisterViewModel::class.java]
    }

    private val adapter by lazy {
        RegistersAdapter()
    }

    private val itemTouchHelper by lazy {
        ItemTouchHelper(SwipeRegister(adapter, registerViewModel))
    }


    private var name: String = ""
    private var address: String = ""
    private var id: Long = 0

    private val listOfRegisters: MutableList<Register> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            registerRv.layoutManager = LinearLayoutManager(requireActivity())
            registerRv.adapter = adapter

            itemTouchHelper.attachToRecyclerView(registerRv)
        }

        binding.newRegisterBttn.setOnClickListener {
            NewRegisterSheet().show(requireActivity().supportFragmentManager, "newRegisterTag")
        }

        createRegisterView()
    }

    override fun onResume() {
        super.onResume()

        registerViewModel.allRegisters.observe(this) {
            it?.let{
                adapter.setList(it)
            }
        }
    }


    private fun createRegisterView() {
        registerViewModel.name.observe(viewLifecycleOwner) { name ->
            this.name = name
        }

        registerViewModel.id.observe(viewLifecycleOwner) { id ->
            this.id = id
        }

        registerViewModel.address.observe(viewLifecycleOwner) { address ->
            this.address = address
            listOfRegisters.add(Register(id = id, name = name, address = address))
            adapter.setList(listOfRegisters)
        }

    }
}