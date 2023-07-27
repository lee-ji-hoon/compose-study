@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RememberKeysScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    val fullName = remember(firstName, lastName) { firstName + lastName }

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "firstName") }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "lastName") }
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            style = MaterialTheme.typography.displayMedium,
            text = fullName
        )
    }
}

@Preview
@Composable
fun RememberKeysScreenPreview() {
    RememberKeysScreen()
}