package com.omar.domain.usecase.getProducts

import com.omar.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUpdatedProductsUseCase @Inject constructor(private val productRepo: ProductsRepo) {
    suspend fun execute(): Flow<GetProductsStates> =
        flow {
            emit(
                try {
                    val products = productRepo.getProductFromRemote()
                    Success(products = products)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Error
                }
            )
        }

}