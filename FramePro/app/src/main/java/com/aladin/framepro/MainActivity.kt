package com.aladin.framepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        binding.registerRv.layoutManager = LinearLayoutManager(this)
        binding.registerRv.adapter = RegistersAdapter()

    }
}