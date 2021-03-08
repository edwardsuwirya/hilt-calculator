package com.enigmacamp.myhiltcalculator.data.api.interceptor

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor(val sharedPreferences: SharedPreferences) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPreferences.getString("token", "")
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder().header("Authorization", token)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}