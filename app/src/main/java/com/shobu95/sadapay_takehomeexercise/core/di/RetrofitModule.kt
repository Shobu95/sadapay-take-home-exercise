package com.shobu95.sadapay_takehomeexercise.core.di

import com.shobu95.sadapay_takehomeexercise.data.source.remote.client.RetrofitClient
import com.shobu95.sadapay_takehomeexercise.data.source.remote.services.GithubRepoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun providesRetrofitClient(): Retrofit {
        return RetrofitClient.retrofit
    }

    @Provides
    @Singleton
    fun providesGithubRepoService(retrofit: Retrofit): GithubRepoService {
        return retrofit.create(GithubRepoService::class.java)
    }

}