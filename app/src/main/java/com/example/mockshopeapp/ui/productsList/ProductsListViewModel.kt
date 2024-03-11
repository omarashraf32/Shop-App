package com.example.mockshopeapp.ui.productsList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CategoryResponse
import com.example.domain.usecase.GetUpdatedProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val getProductUseCase: GetUpdatedProductsUseCase) :
    ViewModel() {

    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val  categories: StateFlow<CategoryResponse?> = _categories
        fun getProduct(){
            viewModelScope.launch {
                try {
                   _categories.value = getProductUseCase()
                }catch (e: Exception){
                    Log.d("ProductViewModel",e.message.toString())
                }

            }
        }
}