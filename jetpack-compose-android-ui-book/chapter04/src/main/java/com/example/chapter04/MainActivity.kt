package com.example.chapter04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chapter04.ui.theme.ComposestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PredefinedLayoutsDemo()
                }
            }
        }
    }
}

@Composable
fun PredefinedLayoutsDemo() {
    val red = remember { mutableStateOf(true) }
    val green = remember { mutableStateOf(true) }
    val blue = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CheckboxWithLabel(
            label = "red",
            state = red
        )
        CheckboxWithLabel(
            label = "green",
            state = green
        )
        CheckboxWithLabel(
            label = "blue",
            state = blue
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            if (red.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                )
            }

            if (green.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                        .background(Color.Green)
                )
            }

            if (blue.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(64.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}

@Composable
fun CheckboxWithLabel(
    label: String,
    state: MutableState<Boolean>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                state.value = state.value.not()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = state.value,
            onCheckedChange = {
                state.value = it
            }
        )

        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
@Preview(heightDp = 600)
fun PredefinedLayoutsDemoPreview() {
    ComposestudyTheme {
        PredefinedLayoutsDemo()
    }
}

@Composable
@Preview(widthDp = 100, heightDp = 100)
fun CheckboxWithLabelPreview() {
    ComposestudyTheme {
        val state = remember {
            mutableStateOf(false)
        }
        CheckboxWithLabel(label = "red", state = state)
    }
}

