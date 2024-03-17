package com.omar.domain.usecase.getProducts

import com.omar.domain.model.Product

sealed interface GetProductsStates

class Success(val products: List<Product>) : GetProductsStates
data object Error : GetProductsStates