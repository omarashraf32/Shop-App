package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.model.CategoryResponse
import com.example.domain.repo.ProductsRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(private val apiService: ApiService): ProductsRepo {
    override suspend fun getProductFromRemote(): CategoryResponse = apiService.getProduct()
}