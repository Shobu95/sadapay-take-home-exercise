package com.shobu95.sadapay_takehomeexercise.ui.screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.shobu95.sadapay_takehomeexercise.ui.screen.components.shimmer.ShimmerListItemEffect

@Composable
fun ShimmerList() {
    LazyColumn {
        items(8) {
            ShimmerListItemEffect()
        }
    }
}