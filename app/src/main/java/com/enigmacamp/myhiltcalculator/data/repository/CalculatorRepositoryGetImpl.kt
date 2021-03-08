package com.enigmacamp.myhiltcalculator.data.repository

import com.enigmacamp.myhiltcalculator.data.api.CalculatorApi
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.model.CalculatorResponse
import javax.inject.Inject

class CalculatorRepositoryGetImpl @Inject constructor(val calculatorApi: CalculatorApi) :
    CalculatorRepository {
    override suspend fun doCount(calculatorRequest: CalculatorRequest): CalculatorResponse {
        val (num1, num2, opr) = calculatorRequest
        return calculatorApi.getCalculatorProcess(num1, num2, opr)
    }

}