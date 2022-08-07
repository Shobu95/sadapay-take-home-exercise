package com.shobu95.sadapay_takehomeexercise.ui.screen.components.trending_repos_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import com.shobu95.sadapay_takehomeexercise.domain.model.RepoOwner

@Preview
@Composable
fun TrendingRepoListItemPrev() {
    TrendingRepoListItem(
        githubRepo = GithubRepo(
            1,
            "Shoaib",
            "Description",
            language = null,
            starCount = 5,
            owner = RepoOwner(
                name = "SHobu",
                avatar = "https://avatars.githubusercontent.com/u/4314092?v=4"
            )
        )
    )
}

@Composable
fun TrendingRepoListItem(githubRepo: GithubRepo) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(githubRepo.owner.avatar),
                contentDescription = "github user avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = githubRepo.repoName,
                    fontSize = 22.sp,
                )
            }
        }

    }
}