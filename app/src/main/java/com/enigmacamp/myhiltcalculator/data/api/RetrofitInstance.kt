package com.enigmacamp.myhiltcalculator.data.api

import com.enigmacamp.myhiltcalculator.util.AppConstant
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val calculatorApi: CalculatorApi by lazy {
        retrofit.create(CalculatorApi::class.java)
    }
}