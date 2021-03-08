package com.enigmacamp.myhiltcalculator.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepository
import com.enigmacamp.myhiltcalculator.di.qualifier.GetCalculator
import com.enigmacamp.myhiltcalculator.di.qualifier.PostCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainActivityViewModel @Inject constructor(@GetCalculator private val repository: CalculatorRepository) :
    ViewModel() {

    fun doCalculatorCount() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        withTimeout(2000) {
            try {
                emit("Please Wait")
                val response = repository.doCount(CalculatorRequest(1, 2, "add"))
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