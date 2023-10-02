package com.example.foodapp.repository

import com.example.foodapp.model.CategoryListResponse
import com.example.foodapp.network.ApiService
import retrofit2.Response

class CategoryRepository(private val apiService: ApiService) {
    suspend fun getCategories(): Response<CategoryListResponse> {
        return apiService.getCategories()
    }

}