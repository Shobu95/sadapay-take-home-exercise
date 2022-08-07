package com.shobu95.sadapay_takehomeexercise.ui.screen.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun GithubTopAppBar(
) {

    var menuDisplayed by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Trending") },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        actions = {

            IconButton(
                onClick = { menuDisplayed = !menuDisplayed }
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    "3 dots dropdown menu"
                )
            }

            DropdownMenu(
                expanded = menuDisplayed,
                onDismissRequest = { menuDisplayed = false }
            ) {
                DropdownMenuItem(
                    onClick = { }
                ) {
                    Text(text = "Dark Mode")
                }
            }
        }
    )
}