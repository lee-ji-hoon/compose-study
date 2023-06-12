package com.example.practice.fast

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.ComposestudyTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EzSnackbar() {
    var counter by remember {
        mutableStateOf(0)
    }

    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }
    ) { paddingValues ->

        Button(
            modifier = Modifier.padding(paddingValues),
            onClick = {
                counter++
                coroutineScope.launch {
                    val result = scaffoldState.showSnackbar(
                        message = "카운터는 ${counter}입니다.",
                        actionLabel = "닫기",
                        duration = SnackbarDuration.Short,
                    )
                    when (result) {
                        // TODO 나중에 Aciton에 따라서 어떤 동작을 하고 싶다면 아래와 같이 활용 가능
                        SnackbarResult.Dismissed -> Unit
                        SnackbarResult.ActionPerformed -> Unit
                    }
                }
            }
        ) {
            Text(text = "plus")
        }
    }
}

@Composable
@Preview
fun EzSnackbarPreview() {
    ComposestudyTheme {
        EzSnackbar()
    }
}