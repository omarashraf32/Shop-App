package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.ProductRepo

class ProductRepoImpl(private val apiService: ApiService): ProductRepo {
    override fun getProductFromRemote(): CategoryResponse = apiService.getProduct()
}