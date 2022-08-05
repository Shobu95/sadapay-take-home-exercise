package com.shobu95.sadapay_takehomeexercise.domain.model

data class GithubRepo(
    val id: Int,
    val repoName: String,
    val description: String,
    val language: String,
    val starCount: Int,
    val owner: RepoOwner,
)

data class RepoOwner(
    val name: String,
    val avatar: String,
)
