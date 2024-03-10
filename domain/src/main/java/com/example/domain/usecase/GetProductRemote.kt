package com.example.domain.usecase

import com.example.domain.repo.ProductRepo

class GetProductRemote(private val productRepo: ProductRepo){
    suspend  operator fun  invoke() = productRepo.getProductFromRemote()

}