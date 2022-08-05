package com.shobu95.sadapay_takehomeexercise.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GithubRepoResponseDto(
    @SerializedName("items") val items: List<GithubRepoDto> = emptyList(),
)

data class GithubRepoDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val repoName: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("stargazers_count")
    val starCount: Int,

    @SerializedName("owner")
    val owner: OwnerDto,
)

data class OwnerDto(

    @SerializedName("login")
    val name: String,

    @SerializedName("avatar_url")
    val avatar: String,
)
