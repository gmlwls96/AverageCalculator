package com.hj.average.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.hj.average.core.network.NetworkResultCallAdapterFactory
import com.hj.average.core.network.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = ""
    private const val TIME_OUT_SECONDS = 60L
    private const val TYPE = "application/json"

    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(TYPE.toMediaType()))
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun okhttp(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(timeout = TIME_OUT_SECONDS, unit = TimeUnit.SECONDS)
            .readTimeout(timeout = TIME_OUT_SECONDS, unit = TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .apply {
                interceptors.forEach { addInterceptor(it) }
            }
            .build()

    @Provides
    @Singleton
    @IntoSet
    fun authInterceptor(): Interceptor =
        AuthInterceptor()
}