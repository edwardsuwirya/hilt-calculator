package com.enigmacamp.myhiltcalculator.data.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder().header("Authorization", "12345")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}