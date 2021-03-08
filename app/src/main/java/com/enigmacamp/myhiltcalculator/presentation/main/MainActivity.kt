package com.enigmacamp.myhiltcalculator.presentation.main

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myhiltcalculator.R
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepositoryGetImpl
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepositoryPostImpl
import com.enigmacamp.myhiltcalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        binding.apply {
            calcButton.setOnClickListener {
                viewModel.doCalculatorCount().observe(this@MainActivity, {
                    sharedPref.edit().putString("token", "12345").apply()
                    Log.d("Calc", it)
                })
            }
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

}