package com.example.etc.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class ItemExample(
    val text: String,
)

@Composable
fun ScrollableScreen() {
    val listState = rememberLazyListState()
    val itemsExamples = (0 until 100).map {
        ItemExample("random + ${Random.nextInt()}")
    }
    var isShow by remember { mutableStateOf(false) }
    LazyColumn(
        state = listState
    ) {
        items(itemsExamples) {

            var isChecked by rememberSaveable { mutableStateOf(false) }
            BoxItem(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Black),
                itemExample = it,
                checked = isChecked,
                onClick = {
                    isChecked = isChecked.not()
                },
                test = {
                    isShow = isShow.not()
                }
            )
        }
    }
    if (isShow) {
        SampleScreen2()
    }
}

@Composable
fun BoxItem(
    modifier: Modifier = Modifier,
    itemExample: ItemExample,
    checked: Boolean,
    onClick: () -> Unit,
    test: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = itemExample.text,
            color = Color.White
        )
        Button(onClick = { test() }) {

        }

        Checkbox(
            checked = checked,
            onCheckedChange = { onClick() },
        )
    }
}

@Composable
fun SampleScreen2() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "SampleScreen2")
    }
}

@Preview
@Composable
fun ScrollableScreenPreview() {
    ScrollableScreen()
}


