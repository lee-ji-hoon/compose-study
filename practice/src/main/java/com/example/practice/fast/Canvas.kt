package com.example.practice.fast

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun EzCanvas() {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawLine(Color.Red, Offset(10f, 10f), Offset(50f, 40f))
        drawCircle(Color.Yellow, 10f, Offset(15f, 30f))
        drawRect(Color.Magenta, Offset(30f, 30f), Size(10f, 10f))

        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))
    }
}

@Composable
@Preview(showBackground = true, heightDp = 100, widthDp = 100)
fun EzCanvasPreview() {
    ComposestudyTheme {
        EzCanvas()
    }
}
