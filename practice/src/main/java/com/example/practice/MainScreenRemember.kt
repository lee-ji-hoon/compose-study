package com.example.practice

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val FRUITS = listOf(
    "apple",
    "tomato",
    "banana"
)

@Composable
fun MainScreenRemember() {
    Log.d("currentRecomposeScope1", "$currentRecomposeScope")

    var randomFruit by remember { mutableStateOf(FRUITS.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.d("currentRecomposeScope2", "$currentRecomposeScope")
        Button(
            modifier = Modifier
                .width(100.dp),
            onClick = { randomFruit = FRUITS.random() }
        ) {
            Log.d("currentRecomposeScope3", "$currentRecomposeScope")
            Text(randomFruit)
        }
    }
}

@Preview
@Composable
fun MainScreenRememberPreview() {
    MainScreenRemember()
}