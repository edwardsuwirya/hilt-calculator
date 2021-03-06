package com.enigmacamp.myhiltcalculator.data.api

import com.enigmacamp.myhiltcalculator.data.model.CalculatorRequest
import com.enigmacamp.myhiltcalculator.data.model.CalculatorResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CalculatorApi {
    @GET("/")
    suspend fun getCalculatorProcess(
        @Query("num1") num1: Int,
        @Query("num2") num2: Int,
        @Query("opr") opr: String,
    ): CalculatorResponse

    @POST("/")
    suspend fun postCalculatorProcess(
        @Body calculatorRequest: CalculatorRequest
    ): CalculatorResponse
}