package com.example.foodapp.network

import com.example.foodapp.model.CategoryListResponse
import com.example.foodapp.util.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    /**
     * Returns a List of all meal categories.
     */
    @GET(BASE_URL)
    suspend fun getCategories(): Response<CategoryListResponse>
}









