package com.omar.domain.usecase.getProducts

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCachedProductsUseCase @Inject constructor() {
    fun execute(): Flow<GetProductsStates> =
        flow {
            emit(Success(emptyList()))
        }

}