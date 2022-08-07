package com.shobu95.sadapay_takehomeexercise.data.source.remote.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    val retrofit: Retrofit by lazy {
        val BASE_URL = "https://api.github.com/"

        val logger = HttpLoggingInterceptor()
        logger.level = Level.BASIC

        val loggerClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        Retrofit.Builder()
            .client(loggerClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}