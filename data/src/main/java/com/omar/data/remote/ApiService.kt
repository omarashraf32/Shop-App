package com.omar.data.remote

import com.omar.domain.model.ProductsListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProduct(): ProductsListResponse

    @GET("products/Any/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductsListResponse>
}