package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

interface ProductRepo {
    fun getProductFromRemote(): CategoryResponse

//    fun getProductFromLocal()


}