package com.example.etc.ui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun CanvasScreen() {
    DrawLine()
    DrawRect()
    DrawCircle()
    DrawOval()
    GradientFill()
    DrawPath()
    DrawPoints()
}

@Composable
fun DrawLine() {
    Canvas(
        modifier = Modifier.size(300.dp),
    ) {
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(
                x = 0f,
                y = 0f
            ),
            end = Offset(
                x = width,
                y = height
            ),
            color = Color.Blue,
            strokeWidth = 16.0f,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(30f, 10f, 10f, 10f),
                phase = 0f
            )
        )
    }
}

@Composable
fun DrawRect() {
    Canvas(modifier = Modifier.size(300.dp)) {
        inset(
            horizontal = 100f,
            vertical = 200f
        ) {
            drawRect(
                color = Color.Red,
                size = size / 2f
            )
        }
    }
}

@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawCircle(
            color = Color.Magenta,
            center = center,
            radius = 120.dp.toPx()
        )
    }
}

@Composable
fun DrawOval() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasHeight = size.height

        drawOval(
            color = Color.Cyan,
            topLeft = Offset(
                x = 25.dp.toPx(),
                y = 90.dp.toPx()
            ),
            size = Size(
                width = canvasHeight - 50.dp.toPx(),
                height = canvasHeight / 2 - 50.dp.toPx()
            ),
            style = Stroke(width = 12.dp.toPx())
        )
    }
}

@Composable
fun GradientFill() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasSize = size
        val colorList = listOf(
            Color.Red, Color.Blue, Color.Magenta, Color.Yellow, Color.Gray, Color.Cyan
        )
        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )
        drawRect(
            brush = brush,
            size = Size(
                width = canvasSize.width / 2,
                height = canvasSize.height / 2
            )
        )
    }
}

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val path = Path().apply {
            moveTo(
                x = 0f,
                y = 0f
            )
            quadraticBezierTo(
                x1 = 50.dp.toPx(),
                y1 = 200.dp.toPx(),
                x2 = 300.dp.toPx(),
                y2 = 300.dp.toPx()
            )
            lineTo(
                x = 270.dp.toPx(),
                y = 100.dp.toPx()
            )
            quadraticBezierTo(
                x1 = 60.dp.toPx(),
                y1 = 80.dp.toPx(),
                x2 = 0f,
                y2 = 0f
            )
            close()
        }
        drawPath(
            path = path,
            color = Color.Green
        )
    }
}

@Composable
fun DrawPoints() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val width = size.width
        val height = size.height
        val points = mutableListOf<Offset>()

        for (x in 0..size.width.toInt()) {
            val y = (sin(x * (2f * PI / width)) * (height / 2) + (height / 2)).toFloat()
            points.add(Offset(x.toFloat(), y))
        }
        drawPoints(
            points = points,
            strokeWidth = 15f,
            pointMode = PointMode.Points,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun CanvasScreenPreview() {
    CanvasScreen()
}