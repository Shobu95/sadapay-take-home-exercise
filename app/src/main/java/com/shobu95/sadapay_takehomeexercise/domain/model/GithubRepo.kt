package com.shobu95.sadapay_takehomeexercise.domain.model

import com.google.gson.annotations.SerializedName

data class GithubRepo(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val repoName: String,

    @SerializedName("owner.login")
    val authorName: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("stargazers_count")
    val starCount: Int,

    @SerializedName("owner.avatar_url")
    val avatar: String,
)
