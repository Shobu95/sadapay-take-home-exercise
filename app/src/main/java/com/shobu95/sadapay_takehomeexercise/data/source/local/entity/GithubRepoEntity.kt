package com.shobu95.sadapay_takehomeexercise.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import com.shobu95.sadapay_takehomeexercise.domain.model.RepoOwner

@Entity(tableName = "github_repo_table")
data class GithubRepoEntity(

    @PrimaryKey var id: Int,
    var repoName: String,
    var authorName: String,
    var description: String?,
    var language: String?,
    var starsCount: Int,
    var avatar: String?,
)

fun List<GithubRepoEntity>.asDomainModel(): List<GithubRepo> {
    return map {
        GithubRepo(
            id = it.id,
            repoName = it.repoName,
            description = it.description,
            language = it.language,
            starCount = it.starsCount,
            owner = RepoOwner(
                name = it.authorName,
                avatar = it.avatar
            )
        )
    }
}
