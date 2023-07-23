package com.example.etc.ui.slot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    text: String,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}

@Preview
@Composable
fun MyTextFieldPreview() {
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text: String ->
        textState = text
    }

    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(5.dp)
    ) {
        Column(
            Modifier.width(IntrinsicSize.Max)
        ) {
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = textState
            )
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            )
        }
        MyTextField(
            text = textState,
            onTextChange = onTextChange
        )
    }
}