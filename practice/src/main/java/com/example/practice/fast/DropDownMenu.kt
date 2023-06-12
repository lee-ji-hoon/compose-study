package com.example.practice.fast

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun EzDropDownMenu() {
    var expandDropDownMenu by remember {
        mutableStateOf(false)
    }

    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text(text = "open dropDown menu")
        }
        Text(text = "counter : $counter")
    }

    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = { expandDropDownMenu = false }
    ) {
        DropdownMenuItem(
            text = {
                Text(text = "증가")
            },
            onClick = {
                counter++
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "감소")
            },
            onClick = {
                counter--
            }
        )
    }
}

@Composable
@Preview(showBackground = true, heightDp = 500)
fun EzDropDownMenuPreview() {
    ComposestudyTheme {
        EzDropDownMenu()
    }
}