package com.shobu95.sadapay_takehomeexercise.ui.screen.components.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerListItem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(brush)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth(fraction = 0.9f)
                .background(brush)
            )
        }
    }
}