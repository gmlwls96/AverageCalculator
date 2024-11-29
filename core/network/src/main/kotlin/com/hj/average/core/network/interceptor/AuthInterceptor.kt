package com.hj.average.core.network.interceptor

import com.hj.average.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain
                .request()
                .newBuilder()
                .addHeader(
                    name = AUTHORIZATION,
                    value = "$PREFIX ${BuildConfig.API_KEY}"
                )
                .build()
        )

    companion object {
        const val AUTHORIZATION = "Authorization"
        const val PREFIX = "KakaoAK"
    }
}