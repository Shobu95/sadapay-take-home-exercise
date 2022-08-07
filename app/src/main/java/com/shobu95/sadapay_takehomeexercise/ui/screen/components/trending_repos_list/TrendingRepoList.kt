package com.shobu95.sadapay_takehomeexercise.ui.screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.trending_repos_list.TrendingRepoListItem

@Composable
fun TrendingRepoList(githubRepoList: List<GithubRepo>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        items(githubRepoList) { githubRepo ->
            TrendingRepoListItem(
                githubRepo = githubRepo,
            )
        }
    }
}