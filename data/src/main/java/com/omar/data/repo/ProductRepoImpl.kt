package com.omar.data.repo

import com.omar.data.remote.ApiService
import com.omar.domain.model.ProductsListResponse
import com.omar.domain.repo.ProductsRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(private val apiService: ApiService): ProductsRepo {
    override suspend fun getProductFromRemote(): ProductsListResponse = apiService.getProduct()
}