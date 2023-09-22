package com.bjelor.dine4fit.data

import com.bjelor.dine4fit.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class PidInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter("pid", BuildConfig.PID_KEY)
            .build()

        val request: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }
}