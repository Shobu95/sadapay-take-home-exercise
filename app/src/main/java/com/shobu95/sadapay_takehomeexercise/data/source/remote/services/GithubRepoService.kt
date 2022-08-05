package com.shobu95.sadapay_takehomeexercise.data.source.remote.services

import com.shobu95.sadapay_takehomeexercise.data.source.remote.dto.GithubRepoResponseDto
import retrofit2.http.GET

interface GithubRepoService {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun getTrendingRepos(): GithubRepoResponseDto
}