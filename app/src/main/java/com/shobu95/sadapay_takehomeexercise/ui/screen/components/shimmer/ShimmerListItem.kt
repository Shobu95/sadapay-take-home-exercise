package com.shobu95.sadapay_takehomeexercise.ui.screen.components.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
            .padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(45.dp))
            .background(brush)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
            )
        }
    }
}