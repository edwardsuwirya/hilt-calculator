package com.enigmacamp.myhiltcalculator.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeout

class MainActivityViewModel(private val repository: CalculatorRepository) : ViewModel() {

    fun doCalculatorCount() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        withTimeout(2000) {
            try {
                emit("Please Wait")
                val response = repository.doCount(CalculatorRequest(4, 7, "mul"))
                emit((response.res).toString())
            } catch (e: Exception) {
                Log.d("Calc", e.toString())
                emit("Error...")
            } finally {
                emit("Done")
            }
        }

    }
}