package io.github.suwasto.sampleandroid.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.suwasto.kmmcomposeshimmer.ShimmerContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                GreetingView("")
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.LightGray
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(20.dp)) {
            ShimmerContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
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
            Spacer(modifier = Modifier.height(10.dp))
            ShimmerContainer {
                Image(
                    painter = painterResource(R.drawable.image),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
