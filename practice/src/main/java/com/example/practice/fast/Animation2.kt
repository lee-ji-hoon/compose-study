package com.example.practice.fast

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun Animation2() {
    var isDarkMode by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isDarkMode, label = null)


    val backgroundColor by transition.animateColor(label = "") { state ->
        when (state) {
            true -> Color.Black
            false -> Color.White
        }
    }

    // 단계 2: `transition`에 대해 `animateColor`를 호출해 `backgroundColor`를 받습니다.
    // 배경색상을 만듭시다. false일 때 하얀 배경, true일 때 검은 배경.

    val color by transition.animateColor(label = "") { state ->
        when (state) {
            true -> Color.White
            false -> Color.Black
        }
    }

    // 단계 3: 글자 색상을 만듭시다.

    // 단계 4: `animateFloat`를 호출해서 알파 값을 만듭시다.

    val alpha by transition.animateFloat(label = "") { state ->
        when (state) {
            true -> 0.7f
            false -> 1f
        }
    }

    // 단계 5: 컬럼에 배경과 알파를 적용합시다.
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        // 단계 6: 라디오 버튼에 글자 색을 적용합시다.
        RadioButtonWithText(text = "일반 모드", color = color, selected = !isDarkMode) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크 모드", color = color, selected = isDarkMode) {
            isDarkMode = true
        }

        // 단계 7: Crossfade를 이용해 `isDarkMode`가 참일 경우
        // `Row`로 항목을 표현하고 거짓일 경우 `Column`으로 표현해봅시다.
        if (isDarkMode) {
            Row {
                Box(modifier = Modifier
                    .background(Color.Red)
                    .size(20.dp)
                    .align(Alignment.CenterVertically)
                ) {
                    Text("1")
                }
                Box(modifier = Modifier
                    .background(Color.Magenta)
                    .size(20.dp)
                    .align(Alignment.CenterVertically)
                ) {
                    Text("2")
                }
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .size(20.dp)
                    .align(Alignment.CenterVertically)
                ) {
                    Text("3")
                }
            }
        } else {
            Column {
                Box(modifier = Modifier
                    .background(Color.Red)
                    .size(20.dp)
                    .align(CenterHorizontally)
                ) {
                    Text("A")
                }
                Box(modifier = Modifier
                    .background(Color.Magenta)
                    .size(20.dp)
                    .align(CenterHorizontally)
                ) {
                    Text("B")
                }
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .size(20.dp)
                    .align(CenterHorizontally)
                ) {
                    Text("C")
                }
            }
        }
//        Crossfade(targetState = isDarkMode, label = "") { state ->
//            when(state) {
//                true -> {
//                    Row {
//                        Box(modifier = Modifier
//                            .background(Color.Red)
//                            .size(20.dp)
//                            .align(Alignment.CenterVertically)
//                        ) {
//                            Text("1")
//                        }
//                        Box(modifier = Modifier
//                            .background(Color.Magenta)
//                            .size(20.dp)
//                            .align(Alignment.CenterVertically)
//                        ) {
//                            Text("2")
//                        }
//                        Box(modifier = Modifier
//                            .background(Color.Blue)
//                            .size(20.dp)
//                            .align(Alignment.CenterVertically)
//                        ) {
//                            Text("3")
//                        }
//                    }
//                }
//                false -> {
//                    Column {
//                        Box(modifier = Modifier
//                            .background(Color.Red)
//                            .size(20.dp)
//                            .align(CenterHorizontally)
//                        ) {
//                            Text("A")
//                        }
//                        Box(modifier = Modifier
//                            .background(Color.Magenta)
//                            .size(20.dp)
//                            .align(CenterHorizontally)
//                        ) {
//                            Text("B")
//                        }
//                        Box(modifier = Modifier
//                            .background(Color.Blue)
//                            .size(20.dp)
//                            .align(CenterHorizontally)
//                        ) {
//                            Text("C")
//                        }
//                    }
//                }
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposestudyTheme {
        Animation2()
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
    ComposestudyTheme {
        RadioButtonWithText(
            text = "라디오 버튼",
            color = Color.Red,
            selected = true,
            onClick = {}
        )
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}
