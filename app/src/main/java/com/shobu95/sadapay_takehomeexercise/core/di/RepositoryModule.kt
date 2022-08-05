package com.shobu95.sadapay_takehomeexercise.core.di

import com.shobu95.sadapay_takehomeexercise.data.repository.GithubRepoRepository
import com.shobu95.sadapay_takehomeexercise.data.repository.GithubRepoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
annotation class GithubRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @GithubRepositoryImpl
    @Singleton
    @Binds
    abstract fun bindGithubRepoRepositoryImpl(
        repositoryImpl: GithubRepoRepositoryImpl,
    ): GithubRepoRepository

}