package com.shobu95.sadapay_takehomeexercise.core.di

import android.app.Application
import androidx.room.Room
import com.shobu95.sadapay_takehomeexercise.data.source.local.dao.GithubRepoDao
import com.shobu95.sadapay_takehomeexercise.data.source.local.database.GithubRepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesGithubRepoDatabase(context: Application): GithubRepoDatabase {
        return Room.databaseBuilder(
            context,
            GithubRepoDatabase::class.java,
            GithubRepoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesGithubRepoDao(database: GithubRepoDatabase): GithubRepoDao {
        return database.githubRepoDao
    }

}