package com.shobu95.sadapay_takehomeexercise.ui.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.shobu95.sadapay_takehomeexercise.R


@Preview
@Composable
fun ErrorViewPrev() {
    ErrorView()
}

@Composable
fun ErrorView() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ErrorAnimation()
        ErrorMessage()
        RetryButton()
    }

}

@Composable
fun ErrorAnimation() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.error_veiw_lottie)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        composition,
        progress,
    )
}

@Composable
fun ErrorMessage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Something went wrong...",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "An alien is probably blocking your signal",
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun RetryButton() {
    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Retry")
    }

}