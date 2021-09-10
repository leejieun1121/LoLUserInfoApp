package com.example.loluserinfoapp.di

import com.example.loluserinfoapp.network.RequestImageInterface
import com.example.loluserinfoapp.network.RequestInterface
import com.example.loluserinfoapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        userService: RequestInterface,
        imageService : RequestImageInterface
    ):MainRepository = MainRepository(userService, imageService )
}