package com.omar.storeApp.ui.productsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omar.domain.model.Product
import com.omar.domain.usecase.getProducts.Error
import com.omar.domain.usecase.getProducts.GetCachedProductsUseCase
import com.omar.domain.usecase.getProducts.GetUpdatedProductsUseCase
import com.omar.domain.usecase.getProducts.Success
import com.omar.storeApp.ui.productsList.states.GetProductsError
import com.omar.storeApp.ui.productsList.states.InitState
import com.omar.storeApp.ui.productsList.states.GetProductsLoading
import com.omar.storeApp.ui.productsList.states.GetProductsSuccess
import com.omar.storeApp.ui.productsList.states.ProductsListStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val getUpdatedProducts: GetUpdatedProductsUseCase,
    private val getCachedProducts: GetCachedProductsUseCase,
) :
    ViewModel() {

    private val _categories: MutableStateFlow<ProductsListStates> =
        MutableStateFlow(InitState)
    val categories: StateFlow<ProductsListStates> = _categories

    fun getProducts() {
        getCachedProducts()
        getUpdatedProducts()
    }

    fun getUpdatedProducts() {
        viewModelScope.launch {
            getUpdatedProducts.execute().collect { state ->
                when (state) {
                    is Success -> emitProducts(state.products)
                    is Error -> emitError()
                }
            }
        }
    }

    private fun getCachedProducts() {
        viewModelScope.launch {
            _categories.emit(GetProductsLoading)
            getCachedProducts.execute().collect { state ->
                when (state) {
                    is Success -> emitProducts(state.products)
                    is Error -> {}
                }
            }
        }
    }

    private suspend fun emitProducts(products: List<Product>) =
        _categories.emit(GetProductsSuccess(products))


    private suspend fun emitError() =
        _categories.emit(GetProductsError)
}