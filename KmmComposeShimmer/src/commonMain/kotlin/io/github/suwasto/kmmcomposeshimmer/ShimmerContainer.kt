package io.github.suwasto.kmmcomposeshimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun ShimmerContainer(
    modifier: Modifier = Modifier,
    shimmerColor: Color = Color.White.copy(alpha = 0.35f),
    backgroundColor: Color = Color.LightGray.copy(alpha = 0.35f),
    durationMillis: Int = 1500,
    content: @Composable () -> Unit
) {
    val transition = rememberInfiniteTransition()

    val shimmerX by transition.animateFloat(
        initialValue = -2f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val brush = remember(shimmerX) {
        Brush.linearGradient(
            colors = listOf(backgroundColor, shimmerColor, backgroundColor),
            start = Offset.Zero,
            end = Offset(shimmerX * 600f, shimmerX * 600f) // smooth diagonal sweep
        )
    }

    Box(
        modifier = modifier
            .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
            .drawWithContent {
                drawContent()
                // Apply shimmer only where children have pixels
                drawRect(
                    brush = brush,
                    blendMode = BlendMode.SrcAtop
                )
            }
    ) {
        content()
    }
}

