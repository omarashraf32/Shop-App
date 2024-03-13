package com.example.data.remote

import com.example.domain.model.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProduct(): CategoryResponse

    @GET("products/Any/{id}")
    fun getProduct(@Path("id") id: Int): Call<CategoryResponse>
}