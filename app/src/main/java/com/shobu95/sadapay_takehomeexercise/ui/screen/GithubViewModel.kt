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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel
@Inject constructor(
    private val useCase: GithubReposUseCase,
) : ViewModel() {
    
    var state by mutableStateOf(GithubUiState())
        private set

    var isDarkTheme by mutableStateOf(false)
        private set

    private var getTransactionsJob: Job? = null


    init {
        getTransactions()
        refreshDataInRepository()
    }

    fun onEvent(event: GithubUiEvent) {
        when (event) {
            GithubUiEvent.OnReload -> {
                state = state.copy(
                    hasLocalData = false
                )
                refreshDataInRepository()
            }
            GithubUiEvent.OnToggleTheme -> {
                isDarkTheme = !isDarkTheme
            }
        }
    }


    private fun refreshDataInRepository() {
        state = state.copy(
            isError = false,
            isLoading = true
        )
        viewModelScope.launch {
            try {
                useCase.refreshGithubRepos()
            } catch (ex: Exception) {
                ex.printStackTrace()
                state = state.copy(
                    isLoading = false,
                    isError = (!state.hasLocalData)
                )
            }
        }
    }


    private fun getTransactions() {
        getTransactionsJob?.cancel()
        getTransactionsJob = useCase.getGithubRepos()
            .onEach { transactions ->
                state = state.copy(
                    githubRepos = transactions,
                    isLoading = false,
                    isError = false,
                    hasLocalData = true,
                )
                if (transactions.isEmpty()) {
                    state = state.copy(
                        hasLocalData = false,
                    )
                }
            }.launchIn(viewModelScope)
    }
}