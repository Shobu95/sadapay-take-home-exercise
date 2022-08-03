package com.shobu95.sadapay_takehomeexercise.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_repo_table")
data class GithubRepo(

    @PrimaryKey var id: Int,
    var repoName: String,
    var authorName: String,
    var description: String,
    var language: String,
    var starsCount: Int,
    var avatar: String,
)
