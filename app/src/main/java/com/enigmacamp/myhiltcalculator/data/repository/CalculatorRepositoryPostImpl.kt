package com.enigmacamp.myhiltcalculator.data.repository

import com.enigmacamp.myhiltcalculator.data.api.RetrofitInstance
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest

class CalculatorRepositoryPostImpl : CalculatorRepository {
    override suspend fun doCount(calculatorRequest: CalculatorRequest) =
        RetrofitInstance.calculatorApi.postCalculatorProcess(calculatorRequest)

}