package com.shobu95.sadapay_takehomeexercise.ui.screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.trending_repos_list.TrendingRepoListItem

@Composable
fun TrendingRepoList(
    githubRepoList: List<GithubRepo>,
    onSwipeRefresh: () -> Unit,
) {
    var isRefreshing by remember { mutableStateOf(false) }
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { onSwipeRefresh() },
    ) {
        LazyColumn(
            modifier = Modifier
                .testTag("repos_list")
                .fillMaxSize()
                .padding(8.dp)) {
            items(githubRepoList) { githubRepo ->
                TrendingRepoListItem(
                    githubRepo = githubRepo,
                )
            }
        }
    }


}