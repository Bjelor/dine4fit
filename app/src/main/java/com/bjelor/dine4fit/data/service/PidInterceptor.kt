package com.bjelor.dine4fit.data.service

import com.bjelor.dine4fit.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val PID_QUERY_PARAMETER = "pid"

class PidInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter(PID_QUERY_PARAMETER, BuildConfig.PID_KEY)
            .build()

        val request: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }
}