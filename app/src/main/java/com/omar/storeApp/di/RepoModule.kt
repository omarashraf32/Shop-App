package com.omar.storeApp.di

import com.omar.data.repo.ProductRepoImpl
import com.omar.domain.repo.ProductsRepo
import dagger.Binds
import dagger.Module
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