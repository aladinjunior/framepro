package com.aladin.framepro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.RegistersAdapter
import com.aladin.framepro.adapters.SwipeRegister
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.ActivityRegisterBinding
import com.aladin.framepro.viewmodels.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""


    }





}