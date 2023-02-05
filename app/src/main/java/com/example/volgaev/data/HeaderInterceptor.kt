package com.example.volgaev.data

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val updatedRequest = request.newBuilder()
            .header(X_API_HEADER, "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
            .build()
        return chain.proceed(updatedRequest)
    }

    companion object {
        private const val X_API_HEADER = "X-API-KEY"
    }
}