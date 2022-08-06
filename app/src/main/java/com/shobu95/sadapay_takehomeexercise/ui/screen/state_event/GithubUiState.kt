package com.shobu95.sadapay_takehomeexercise.ui.screen.state_event

import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo

data class GithubUiState(
    val githubRepos: List<GithubRepo> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
