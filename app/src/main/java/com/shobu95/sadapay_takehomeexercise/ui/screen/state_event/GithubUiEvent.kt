package com.shobu95.sadapay_takehomeexercise.ui.screen.state_event

sealed class GithubUiEvent {
    object OnToggleTheme : GithubUiEvent()
    object OnReload : GithubUiEvent()
}