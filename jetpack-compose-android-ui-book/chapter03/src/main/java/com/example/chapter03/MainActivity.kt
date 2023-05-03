package com.example.chapter03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.chapter03.ui.theme.ComposestudyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    OrderDemo()
                }
            }
        }
    }
}

@Composable
fun OrderDemo() {
    var color by remember {
        mutableStateOf(Color.Blue)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp)
        .border(BorderStroke(width = 2.dp, color = color))
        .background(Color.LightGray)
        .clickable {
            color = if (color == Color.Blue) Color.Red else Color.Blue
        }
    )
}

@Composable
fun ColorPickerView() {
    Column(
        modifier = Modifier.width(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val color = remember {
            mutableStateOf(Color.Magenta)
        }
        ColorPicker(color = color)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color.value),
            text = "#${color.value.toArgb().toUInt().toString(16)}",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge.merge(
                TextStyle(
                    color = color.value.complementary()
                )
            )
        )
    }
}

@Composable
fun ColorPicker(color: MutableState<Color>) {
    val red = color.value.red
    val green = color.value.green
    val blue = color.value.blue

    Column {
        Slider(
            value = red,
            onValueChange = { color.value = Color(it, green, blue) }
        )
        Slider(
            value = green,
            onValueChange = { color.value = Color(red, it, blue) }
        )
        Slider(
            value = blue,
            onValueChange = { color.value = Color(red, green, it) }
        )
    }
}

@Composable
@Preview(heightDp = 300)
fun OrderDemoPreview() {
    ComposestudyTheme {
        OrderDemo()
    }
}

@Composable
@Preview
fun ColorPickerViewPreview() {
    ComposestudyTheme {
        ColorPickerView()
    }
}

@Composable
@Preview
fun ColorPickerPreview() {
    ComposestudyTheme {
        val color = remember {
            mutableStateOf(Color.Magenta)
        }
        ColorPicker(color)
    }
}
