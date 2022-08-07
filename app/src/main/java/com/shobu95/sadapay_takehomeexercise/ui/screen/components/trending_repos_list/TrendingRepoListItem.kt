package com.shobu95.sadapay_takehomeexercise.ui.screen.components.trending_repos_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shobu95.sadapay_takehomeexercise.R
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import com.shobu95.sadapay_takehomeexercise.domain.model.RepoOwner

@Preview
@Composable
fun TrendingRepoListItemPrev() {
    TrendingRepoListItem(
        githubRepo = GithubRepo(
            1,
            "Shoaib",
            "this is a description",
            language = "Python",
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

    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { isExpanded = !isExpanded },
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(githubRepo.owner.avatar),
                contentDescription = "github user avatar",
                modifier = Modifier
                    .padding(end = 14.dp, start = 6.dp)
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = githubRepo.owner.name,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = githubRepo.repoName,
                    style = MaterialTheme.typography.h6,
                )
                if (isExpanded) {
                    ExpandedItemView(githubRepo = githubRepo)
                }
            }
        }

    }
}

@Composable
fun ExpandedItemView(githubRepo: GithubRepo) {
    Column(modifier = Modifier.padding(top = 4.dp)) {
        Text(
            text = githubRepo.description!!,
            style = MaterialTheme.typography.body2,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextWithIcon(
                icon = painterResource(id = R.drawable.language_icon),
                text = githubRepo.language ?: "N/A"
            )

            TextWithIcon(
                icon = painterResource(id = R.drawable.stars_icon),
                text = githubRepo.starCount.toString()
            )
        }
    }
}

@Composable
fun TextWithIcon(icon: Painter, text: String) {
    Row(
        modifier = Modifier.padding(start = 8.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(25.dp)
                .padding(end = 4.dp),
            painter = icon,
            contentDescription = text,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
        )
    }
}