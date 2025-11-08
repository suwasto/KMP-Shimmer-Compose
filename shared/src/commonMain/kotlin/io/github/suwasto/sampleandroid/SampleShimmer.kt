package io.github.suwasto.sampleandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.suwasto.kmmcomposeshimmer.LocalShimmerTheme
import io.github.suwasto.kmmcomposeshimmer.ShimmerContainer
import io.github.suwasto.kmmcomposeshimmer.ShimmerSurface
import io.github.suwasto.kmmcomposeshimmer.ShimmerThemeValues

@Composable
fun SampleShimmer() {
    CompositionLocalProvider(LocalShimmerTheme provides ShimmerThemeValues(
        backgroundColor = Color.LightGray.copy(alpha = 0.5f),
        shimmerColor = Color.White.copy(alpha = 0.5f),
        durationMillis = 1400
    )) {
        Scaffold(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            backgroundColor = Color.White
        ) {
            Column(modifier = Modifier
                .padding(it)
                .padding(20.dp)) {
                Text("Default theme shimmer")
                Spacer(modifier = Modifier.height(20.dp))
                ShimmerContainer {
                    Text("THIS TEXT SHIMMERING", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                ShimmerContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .clip(CircleShape)
                            .size(50.dp)
                            .background(Color.Gray))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp)) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .background(Color.Gray)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .background(Color.Gray)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                ShimmerContainer(
                    modifier = Modifier.fillMaxWidth()
                        .height(80.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)) {
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Green)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Green)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text("Shimmer with background blue 0.5f and shimmer color cyan 0.35f")
                Spacer(modifier = Modifier.height(20.dp))
                CompositionLocalProvider(LocalShimmerTheme provides ShimmerThemeValues(
                    backgroundColor = Color.Blue.copy(alpha = 0.5f),
                    shimmerColor = Color.Cyan.copy(alpha = 0.35f),
                    durationMillis = 1400
                )) {
                    ShimmerContainer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier
                                .clip(CircleShape)
                                .size(50.dp)
                                .background(Color.Gray))
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 8.dp)) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .background(Color.Gray)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .background(Color.Gray)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text("Sample Shimmer Surface >> Click to enable disable shimmer")
                Spacer(modifier = Modifier.height(20.dp))
                var isLoading by remember { mutableStateOf(true) }
                ShimmerSurface(
                    isLoading = isLoading
                ) {
                    Column(modifier = Modifier.clickable {
                        isLoading = !isLoading
                    }) {
                        Text("THIS TEXT Not SHIMMERING", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        ShimmerContainer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .padding(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(modifier = Modifier
                                    .clip(CircleShape)
                                    .size(50.dp)
                                    .background(Color.Gray))
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(modifier = Modifier
                                    .weight(1f)
                                    .padding(vertical = 8.dp)) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .fillMaxWidth()
                                            .weight(1f)
                                            .background(Color.Gray)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .fillMaxWidth()
                                            .weight(1f)
                                            .background(Color.Gray)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("NOT INSIDE SHIMMER CONTAINER NOT SHIMMERING", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        ShimmerContainer(
                            modifier = Modifier.fillMaxWidth()
                                .height(80.dp)
                                .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .padding(8.dp)
                        ) {
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 8.dp)) {
                                Box(
                                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .background(Color.Green)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Box(
                                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .background(Color.Green)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}