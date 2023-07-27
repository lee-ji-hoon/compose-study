@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val usernameRegex by lazy { "^[a-zA-Z][a-zA-Z0-9_]{2,19}$".toRegex() }
private const val TAG = "TAG"

@Composable
fun RememberSampleScreen() {
    var username by remember { mutableStateOf("") }
    val submitEnabled by remember { derivedStateOf { isUsernameValid(username) }  }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = { username = it }
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            onClick = { },
            enabled = submitEnabled
        ) {
            Text(text = "submit")
        }
    }
}

fun isUsernameValid(username: String): Boolean {
    return username.matches(usernameRegex)
}

@Preview
@Composable
fun RememberSampleScreenPreview() {
    RememberSampleScreen()
}