package com.example.foodapp.interfaces

import com.example.foodapp.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataServices {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

}

