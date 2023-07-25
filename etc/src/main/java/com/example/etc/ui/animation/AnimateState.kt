package com.example.etc.ui.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.etc.R

@Composable
fun AnimateStateScreen() {
    var rotated by remember { mutableStateOf(false) }
    val angle by animateFloatAsState(
        targetValue = if (rotated) 360f else 0f,
        animationSpec = tween(
            durationMillis = 2500,
            easing = LinearEasing
        ),
        label = "Propeller Animation"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.propeller),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(angle)
                .padding(10.dp)
                .size(300.dp)
        )

        Button(
            onClick = { rotated = rotated.not() },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Rotate Propeller")
        }
    }
}

enum class BoxColor {
    RED, MAGENTA
}

@Composable
fun ColorChangeScreen() {
    var colorState by remember { mutableStateOf(BoxColor.RED) }

    val animateColor by animateColorAsState(
        targetValue = when (colorState) {
            BoxColor.RED -> Color.Magenta
            BoxColor.MAGENTA -> Color.Red
        } ,
        animationSpec = tween(4500),
        label = "animateColor"
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(200.dp)
                .background(animateColor)
        )

        Button(
            onClick = {
                colorState = when (colorState) {
                    BoxColor.RED -> BoxColor.MAGENTA
                    BoxColor.MAGENTA -> BoxColor.RED
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Change Color")
        }
    }
}

@Preview
@Composable
fun AnimateStateScreenPreview() {
    AnimateStateScreen()
}

@Preview
@Composable
fun ColorChangeScreenPreview() {
    ColorChangeScreen()
}