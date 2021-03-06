package com.enigmacamp.myhiltcalculator.data.repository

import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.model.CalculatorResponse

interface CalculatorRepository {
    suspend fun doCount(calculatorRequest: CalculatorRequest): CalculatorResponse
}