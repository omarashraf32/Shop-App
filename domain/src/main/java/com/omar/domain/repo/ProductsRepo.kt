package com.omar.domain.repo

import com.omar.domain.model.ProductsListResponse

interface ProductsRepo {
 suspend fun getProductFromRemote(): ProductsListResponse

//    fun getProductFromLocal()


}