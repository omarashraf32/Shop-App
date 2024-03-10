package com.example.domain.usecase

import com.example.domain.repo.ProductsRepo

class GetUpdatedProductsUseCase(private val productRepo: ProductsRepo){
    suspend  operator fun  invoke() = productRepo.getProductFromRemote()

}