package com.shobu95.sadapay_takehomeexercise.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.sadapay_takehomeexercise.domain.use_case.GithubReposUseCase
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiEvent
import com.shobu95.sadapay_takehomeexercise.ui.screen.state_event.GithubUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel
@Inject constructor(
    private val useCase: GithubReposUseCase,
) : ViewModel() {

    var state by mutableStateOf(GithubUiState())
        private set

    init {
        refreshDataInRepository()
        useCase.getGithubRepos().map {
            if (it.isNotEmpty()) {
                state = state.copy(
                    githubRepos = it,
                    isLoading = false,
                    isError = false
                )
            }

        }
    }

    fun onEvent(event: GithubUiEvent) {
        when (event) {
            GithubUiEvent.OnReload -> {
                viewModelScope.launch {
                    refreshDataInRepository()
                }
            }
        }
    }


    private fun refreshDataInRepository() {
        viewModelScope.launch {
            state = try {
                useCase.refreshGithubRepos()
                state.copy(
                    isLoading = true,
                    isError = false,
                )
            } catch (ex: Exception) {
                state.copy(
                    isLoading = false,
                    isError = true
                )
            }
        }
    }
}