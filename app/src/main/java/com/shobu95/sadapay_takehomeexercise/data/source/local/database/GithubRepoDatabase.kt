package com.shobu95.sadapay_takehomeexercise.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
        private const val DATABASE_NAME = "github_repo_database"

        @Volatile // changes in this field are notified to other threads
        private var INSTANCE: GithubRepoDatabase? = null

        fun getInstance(context: Context): GithubRepoDatabase {
            // can be used by one thread at a time
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GithubRepoDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}