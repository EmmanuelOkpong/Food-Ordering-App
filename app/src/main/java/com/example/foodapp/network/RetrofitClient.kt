package com.example.foodapp.network

import com.example.foodapp.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object RetrofitClient {
    val apiService: ApiService by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

private fun createHttpClient(): OkHttpClient {
    val interceptor = createLoggingInterceptor()
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}

private fun createLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }



