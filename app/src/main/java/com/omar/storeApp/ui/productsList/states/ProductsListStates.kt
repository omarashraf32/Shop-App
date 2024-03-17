package com.omar.storeApp.ui.productsList.states

import com.omar.domain.model.Product

sealed class ProductsListStates

data object InitState : ProductsListStates()
data object GetProductsLoading : ProductsListStates()

class GetProductsSuccess(val products: List<Product>) : ProductsListStates()
data object GetProductsError : ProductsListStates()
