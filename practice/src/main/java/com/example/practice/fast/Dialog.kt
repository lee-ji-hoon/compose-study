package com.example.practice.fast

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun EzDialog() {
    var openDialog by remember {
        mutableStateOf(false)
    }

    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "open dialog")
        }
        Text(text = "count : $counter")
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            }, confirmButton = {
                Button(onClick = {
                    counter++
                    openDialog = false
                }) {
                    Text(text = "plus")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialog = false
                }) {
                    Text(text = "close")
                }
            }, title = {
                Text(text = "Hello")
            }, text = {
                Text(text = "Lee Ji Hoon")
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun EzDialogPreview() {
    ComposestudyTheme {
        EzDialog()
    }
}