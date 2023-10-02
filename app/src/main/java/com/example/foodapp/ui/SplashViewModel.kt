package com.example.foodapp.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.model.CategoryListResponse
import com.example.foodapp.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Response


/**
 * The [ViewModel] that is attached to the [SplashActivity].
 */

class SplashViewModel : ViewModel() {
    private val _categories = MutableLiveData<Response<CategoryListResponse>>()
    val categories: LiveData<Response<CategoryListResponse>> = _categories

    fun getCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getCategories()
                _categories.value = response
            } catch (e: Exception) {
                e.localizedMessage
            }
        }
    }


}