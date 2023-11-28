package com.aladin.framepro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.aladin.framepro.R
import com.aladin.framepro.databinding.ActivityMainBinding
import com.aladin.framepro.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment_container)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        with(binding){
            bttnRegister.setOnClickListener{
                NewRegisterSheet(Navigation()).show(this@MainActivity.supportFragmentManager, "newRegisterTag")
            }

            homeIc.setOnClickListener {
                navController.navigate(R.id.register)
            }

            aboutIc.setOnClickListener {
                navController.navigate(R.id.about)
            }

        }



    }

    fun disableBottomBar() {
        with(binding){
            bttnRegister.isEnabled = false
            aboutIc.isEnabled = false
            homeIc.isEnabled = false
        }

    }




}