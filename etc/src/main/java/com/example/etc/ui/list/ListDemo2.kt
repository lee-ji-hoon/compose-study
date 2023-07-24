package com.example.etc.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ColumnList() {

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(
                onClick = {
                    coroutineScope.launch { scrollState.animateScrollTo(0) }
                },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp),
            ) {
                Text(text = "Top")
            }

            Button(
                onClick = {
                    coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp)
            ) {
                Text(text = "End")
            }
        }
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            repeat(500) {
                Text(
                    text = "List Item $it",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ColumnListPreview() {
    ColumnList()
}