package com.example.loluserinfoapp.di

import com.example.loluserinfoapp.network.RequestImageInterface
import com.example.loluserinfoapp.network.RequestInterface
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private val baseURL = "https://kr.api.riotgames.com/lol/"
private val imageURL = "http://ddragon.leagueoflegends.com/cdn/11.18.1/img/"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService() : RequestInterface = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RequestInterface::class.java)


    @Singleton
    @Provides
    fun provideImageRetrofitService() : RequestImageInterface = Retrofit.Builder()
        .baseUrl(imageURL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(RequestImageInterface::class.java)


}