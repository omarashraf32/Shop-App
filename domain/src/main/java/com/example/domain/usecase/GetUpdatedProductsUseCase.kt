package com.example.domain.usecase

import com.example.domain.repo.ProductsRepo
import javax.inject.Inject

class GetUpdatedProductsUseCase @Inject constructor(private val productRepo: ProductsRepo){
    suspend  fun  execute() = productRepo.getProductFromRemote()

}