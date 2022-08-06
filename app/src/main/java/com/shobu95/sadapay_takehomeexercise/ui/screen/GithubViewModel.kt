package com.shobu95.sadapay_takehomeexercise.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shobu95.sadapay_takehomeexercise.domain.use_case.GithubReposUseCase
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiEvent
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GithubViewModel
@Inject constructor(
    val useCase: GithubReposUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(GithubUiState())
    val state: State<GithubUiState> = _state

    fun onEvent(event: GithubUiEvent) {

        when (event) {

            GithubUiEvent.OnReload -> {

            }
        }

    }
}