package com.example.service

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val urlBuilder = request.url().newBuilder()


        request = request
            .newBuilder()
            .url(urlBuilder.build())
            .addHeader("Content-Type", "application/json")
            .build()


        return chain.proceed(request)
    }

}
