package com.aladin.framepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.ActivityMainBinding
import com.aladin.framepro.ui.NewRegisterSheet
import com.aladin.framepro.viewmodels.RegisterViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val registerViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    private lateinit var adapter: RegistersAdapter

    private val listOfRegisters: MutableList<Register> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        adapter = RegistersAdapter()

        binding.registerRv.layoutManager = LinearLayoutManager(this)
        binding.registerRv.adapter = adapter

        binding.newRegisterBttn.setOnClickListener {
            NewRegisterSheet().show(supportFragmentManager, "newRegisterTag")
        }

    }


}