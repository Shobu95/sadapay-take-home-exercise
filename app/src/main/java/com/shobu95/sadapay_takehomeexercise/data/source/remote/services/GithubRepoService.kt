package com.shobu95.sadapay_takehomeexercise.data.source.remote.services

import com.shobu95.sadapay_takehomeexercise.data.source.remote.response.TrendingReposResponse
import retrofit2.http.GET

interface GithubRepoService {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun getTrendingRepos(): TrendingReposResponse
}