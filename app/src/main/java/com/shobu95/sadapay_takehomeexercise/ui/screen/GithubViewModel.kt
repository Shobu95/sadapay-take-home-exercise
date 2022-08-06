package com.shobu95.sadapay_takehomeexercise.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.shobu95.sadapay_takehomeexercise.domain.use_case.GithubReposUseCase
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiEvent
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiState
import javax.inject.Inject

class GithubViewModel
@Inject constructor(
    val useCase: GithubReposUseCase,
) {

    private val _state = mutableStateOf(GithubUiState())
    val state: State<GithubUiState> = _state

    fun onEvent(event: GithubUiEvent) {

        when (event) {

            GithubUiEvent.OnReload -> {

            }
        }

    }
}