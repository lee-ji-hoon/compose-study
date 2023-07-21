package com.example.practice.stableex

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun StableScreen(viewModel: StableViewModel = viewModel()) {

    val value by viewModel.value.collectAsState()
    val action by remember { mutableStateOf({ viewModel.plusValue() }) }

    StableComposable(value, action)
}

@Composable
fun StableComposable(value: Int, onClick: () -> Unit) {
    Log.d("StableComposable", "onclick ${onClick.hashCode()}")

    Text(
        text = value.toString(),
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .height(48.dp)
    )
}

@Preview
@Composable
fun UnStableScreenPreview() {
    ComposestudyTheme {
        StableScreen()
    }
}
