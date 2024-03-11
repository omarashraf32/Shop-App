package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.model.CategoryResponse
import com.example.domain.repo.ProductsRepo

class ProductRepoImpl(private val apiService: ApiService): ProductsRepo {
    override suspend fun getProductFromRemote(): CategoryResponse = apiService.getProduct()
}