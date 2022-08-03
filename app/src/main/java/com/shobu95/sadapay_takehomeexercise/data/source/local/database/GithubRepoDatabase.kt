package com.shobu95.sadapay_takehomeexercise.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shobu95.sadapay_takehomeexercise.data.source.local.dao.GithubRepoDao
import com.shobu95.sadapay_takehomeexercise.data.source.local.entity.GithubRepoEntity


@Database(
    entities = [GithubRepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubRepoDatabase : RoomDatabase() {

    abstract val githubRepoDao: GithubRepoDao

    companion object {
        const val DATABASE_NAME = "github_repo_database"
    }
}