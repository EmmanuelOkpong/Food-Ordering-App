package com.example.foodapp.retrofitclient

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstant {


    companion object {
        val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        private var logger:HttpLoggingInterceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttp:OkHttpClient.Builder=OkHttpClient.Builder().addInterceptor(logger)
        private var retrofit: Retrofit.Builder? = null
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttp.build())
                }
                return retrofit?.build()
            }

    }
}