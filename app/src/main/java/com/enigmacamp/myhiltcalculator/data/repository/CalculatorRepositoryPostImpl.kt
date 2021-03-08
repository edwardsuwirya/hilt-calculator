package com.enigmacamp.myhiltcalculator.data.repository

import com.enigmacamp.myhiltcalculator.data.api.CalculatorApi
import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import javax.inject.Inject

class CalculatorRepositoryPostImpl @Inject constructor(val calculatorApi: CalculatorApi) :
    CalculatorRepository {
    override suspend fun doCount(calculatorRequest: CalculatorRequest) =
        calculatorApi.postCalculatorProcess(calculatorRequest)

}