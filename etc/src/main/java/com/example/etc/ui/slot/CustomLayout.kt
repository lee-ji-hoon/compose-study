package com.example.etc.ui.slot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CascadeLayout(
    modifier: Modifier = Modifier,
    spacing: Int = 0,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        var indent = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoord = 0
            measurables
                .map { measurable -> measurable.measure(constraints) } // 각 자식들을 측정
                .forEach { placeable ->
                    placeable.placeRelative(
                        x = indent,
                        y = yCoord
                    )
                    indent += placeable.width + spacing
                    yCoord += placeable.height + spacing
                }
        }
    }
}

@Composable
fun DoNothingLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeable = measurables.map { measurable ->
            measurable.measure(constraints) // 각 자식들을 측정
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeable.forEach { placeable ->
                placeable.placeRelative(x = 0, y = 0)
            }
        }
    }
}

@Preview
@Composable
fun DoNothingLayoutPreview() {
    Text(text = "Text Line 1")
    Text(text = "Text Line 2")
    Text(text = "Text Line 3")
    Text(text = "Text Line 4")
}

@Preview
@Composable
fun CascadeLayoutPreview() {
    Box {
        CascadeLayout(spacing = 20) {
            Box(modifier = Modifier.size(60.dp).background(Color.Blue))
            Box(modifier = Modifier.size(80.dp, 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(90.dp, 100.dp).background(Color.Cyan))
            Box(modifier = Modifier.size(50.dp).background(Color.Magenta))
            Box(modifier = Modifier.size(70.dp).background(Color.Green))
        }
    }
}
