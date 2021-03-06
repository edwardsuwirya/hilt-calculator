package com.enigmacamp.myhiltcalculator.data.repository

import com.enigmacamp.myhiltcalculator.data.api.RetrofitInstance
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.model.CalculatorResponse

class CalculatorRepositoryGetImpl : CalculatorRepository {
    override suspend fun doCount(calculatorRequest: CalculatorRequest): CalculatorResponse {
        val (num1, num2, opr) = calculatorRequest
        return RetrofitInstance.calculatorApi.getCalculatorProcess(num1, num2, opr)
    }

}