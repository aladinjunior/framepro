package com.aladin.framepro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.adapters.SwipeRegister
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.ActivityMainBinding
import com.aladin.framepro.viewmodels.RegisterViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val registerViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        with(binding){
            registerRv.layoutManager = LinearLayoutManager(this@MainActivity)
            registerRv.adapter = adapter

            itemTouchHelper.attachToRecyclerView(registerRv)
        }




        binding.newRegisterBttn.setOnClickListener {
            NewRegisterSheet().show(supportFragmentManager, "newRegisterTag")
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
        registerViewModel.name.observe(this) { name ->
            this.name = name
        }

        registerViewModel.id.observe(this) { id ->
            this.id = id
        }

        registerViewModel.address.observe(this) { address ->
            this.address = address
            listOfRegisters.add(Register(id = id, name = name, address = address))
            adapter.setList(listOfRegisters)
        }

    }

}