package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.R
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.adapters.SwipeRegister
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentRegisterBinding
import com.aladin.framepro.util.Navigation
import com.aladin.framepro.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    private val adapter by lazy {
        RegistersAdapter{  register ->
            Navigation().goToResultScreen(this@RegisterFragment, register)

        }
    }

    private val itemTouchHelper by lazy {
        ItemTouchHelper(SwipeRegister(adapter, viewModel))
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


//        createRegisterView()

    }

    override fun onResume() {
        super.onResume()


        viewModel.allRegisters.observe(this) {
            it?.let{
                adapter.setList(it)
                onEmptyList(it)
            }
        }
    }

    private fun onEmptyList(list: List<Register>){
        if(list.isEmpty()){
            binding.emptyImage.visibility = View.VISIBLE
            binding.noRegisterText.visibility = View.VISIBLE
            binding.noRegisterSubtext.visibility = View.VISIBLE
            binding.image.visibility = View.GONE
        } else {
            binding.emptyImage.visibility = View.GONE
            binding.noRegisterText.visibility = View.GONE
            binding.noRegisterSubtext.visibility = View.GONE
            binding.image.visibility = View.VISIBLE
        }
    }


}