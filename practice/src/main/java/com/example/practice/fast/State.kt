@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practice.fast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun StateTest() {
    var pyeong by rememberSaveable { mutableStateOf("23") }
    var squaremeter by rememberSaveable { mutableStateOf((23 * 3.306).toString()) }

    StateTest2(pyeong = pyeong, squareMeter = squaremeter, onPyeongChange = {
        if (it.isBlank()) {
            pyeong = ""
            squaremeter = ""
            return@StateTest2
        }
        val numericValue = it.toFloatOrNull() ?: return@StateTest2
        pyeong = it
        squaremeter = (numericValue * 3).toString()
    })
}

@Composable
fun StateTest2(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text(text = "평")
            },
        )

        OutlinedTextField(
            value = squareMeter,
            onValueChange = {

            },
            label = {
                Text(text = "제곱미터")
            },
        )
    }
}

@Composable
@Preview
fun StateTestPreview() {
    ComposestudyTheme {
        StateTest()
    }
}

