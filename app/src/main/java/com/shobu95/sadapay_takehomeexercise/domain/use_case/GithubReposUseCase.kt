package com.shobu95.sadapay_takehomeexercise.domain.use_case

import com.shobu95.sadapay_takehomeexercise.core.di.GithubRepositoryImpl
import com.shobu95.sadapay_takehomeexercise.data.repository.GithubRepoRepository
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubReposUseCase
@Inject constructor(
    @GithubRepositoryImpl
    private val repository: GithubRepoRepository,
) {

    fun getGithubRepos(): Flow<List<GithubRepo>> {
        return repository.getAll()
    }

    suspend fun refreshGithubRepos() {
        repository.refreshAll()
    }

}