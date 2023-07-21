package com.example.etc.ui.slot

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SlotDemo(middleContent: @Composable () -> Unit) {
    Column {
        Text(text = "Top Text")
        middleContent()
        Text(text = "Bottom Text")

    }
}

@Composable
fun ButtonDemo() {
    Button(onClick = { }) {
        Text(text = "Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun SlotDemoPreview() {
    SlotDemo {
        ButtonDemo()
    }
}