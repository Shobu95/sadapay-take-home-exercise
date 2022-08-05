package com.shobu95.sadapay_takehomeexercise.data.repository

import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GithubRepoRepository {

    fun getAll(): Flow<List<GithubRepo>>

    suspend fun refreshAll()
}