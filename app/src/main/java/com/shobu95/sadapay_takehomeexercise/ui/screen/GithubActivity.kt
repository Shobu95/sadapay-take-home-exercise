package com.shobu95.sadapay_takehomeexercise.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.ErrorView
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.ShimmerList
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.TrendingRepoList
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiEvent
import com.shobu95.sadapay_takehomeexercise.ui.theme.GithubTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GithubActivity : ComponentActivity() {

    private val viewModel by viewModels<GithubViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) { ScreenBody(viewModel) }
            }
        }
    }
}

@Composable
fun ScreenBody(viewModel: GithubViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (viewModel.state.isLoading) {
            ShimmerList()
        }

        if (viewModel.state.isError) {
            ErrorView { viewModel.onEvent(GithubUiEvent.OnReload) }
        }

        if (viewModel.state.githubRepos.isNotEmpty()) {
            TrendingRepoList(githubRepoList = viewModel.state.githubRepos)
        }

    }
}




