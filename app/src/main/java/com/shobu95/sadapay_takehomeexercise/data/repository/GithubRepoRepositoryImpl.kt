package com.shobu95.sadapay_takehomeexercise.data.repository

import com.shobu95.sadapay_takehomeexercise.data.source.local.dao.GithubRepoDao
import com.shobu95.sadapay_takehomeexercise.data.source.local.entity.asDomainModel
import com.shobu95.sadapay_takehomeexercise.data.source.remote.dto.asDatabaseModel
import com.shobu95.sadapay_takehomeexercise.data.source.remote.services.GithubRepoService
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GithubRepoRepositoryImpl(
    val dao: GithubRepoDao,
    val service: GithubRepoService,
) : GithubRepoRepository {


    override fun getAll(): Flow<List<GithubRepo>> {
        return dao.getAll().map {
            it.asDomainModel()
        }
    }

    override suspend fun refreshAll() {
        withContext(Dispatchers.IO) {
            val githubRepoList = service.getTrendingRepos()
            dao.insertAll(githubRepoList.asDatabaseModel())
        }
    }
}