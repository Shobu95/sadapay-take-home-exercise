package com.shobu95.sadapay_takehomeexercise.data.source.remote.client

import com.shobu95.sadapay_takehomeexercise.data.source.remote.services.GithubRepoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitClient {

    private val retrofit by lazy {
        val BASE_URL = "https://api.github.com/"

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val githubRepoService: GithubRepoService by lazy {
        retrofit.create(GithubRepoService::class.java)
    }


}