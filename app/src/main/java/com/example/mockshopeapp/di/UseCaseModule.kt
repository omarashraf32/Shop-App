package com.example.mockshopeapp.di

import com.example.data.repo.ProductRepoImpl
import com.example.domain.repo.ProductsRepo
import com.example.domain.usecase.GetUpdatedProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
//    @Provides
//    fun provideUseCase(productsRepo: ProductsRepo): GetUpdatedProductsUseCase{
//        return GetUpdatedProductsUseCase(productsRepo)
//
//    }
}