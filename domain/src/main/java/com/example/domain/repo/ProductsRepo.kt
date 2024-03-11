package com.example.domain.repo

import com.example.domain.model.CategoryResponse

interface ProductsRepo {
 suspend fun getProductFromRemote(): CategoryResponse

//    fun getProductFromLocal()


}