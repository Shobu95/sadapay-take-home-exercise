package com.shobu95.sadapay_takehomeexercise.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.shobu95.sadapay_takehomeexercise.data.source.local.entity.GithubRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubRepoDao {

    @Query("SELECT * FROM github_repo_table")
    fun getAll(): Flow<List<GithubRepoEntity>>

}