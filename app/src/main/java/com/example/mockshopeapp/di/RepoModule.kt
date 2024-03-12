package com.example.mockshopeapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.ProductRepoImpl
import com.example.domain.repo.ProductsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
//    @Provides
//    fun provideRepo(apiService: ApiService): ProductsRepo{
//        return ProductRepoImpl(apiService)
//    }
    @Binds
    abstract fun bindsProductRepo(repo: ProductRepoImpl): ProductsRepo
}