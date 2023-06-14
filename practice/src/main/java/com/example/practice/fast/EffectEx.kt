@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practice.fast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun EffectEx(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = snackbarHostState) {
        snackbarHostState.showSnackbar(
            message = "Hello Compose",
            duration = SnackbarDuration.Short
        )
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    println("[이지] ON_START")
                }

                Lifecycle.Event.ON_STOP -> {
                    println("[이지] ON_STOP")
                }

                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            LaunchedEffect(key1 = snackbarHostState) {
                snackbarHostState.showSnackbar(
                    message = "Hello Compose",
                    duration = SnackbarDuration.Short
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EffectExPreview() {
    ComposestudyTheme {
        EffectEx()
    }
}