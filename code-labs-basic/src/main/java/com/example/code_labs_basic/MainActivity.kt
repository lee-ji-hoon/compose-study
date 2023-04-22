package com.example.code_labs_basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Dimension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.code_labs_basic.ui.theme.ComposestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyApp(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable {
        mutableStateOf(true)
    }

    Surface(modifier = modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1_000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPaddingBottomWhenExpanded(expanded.value, 48.dp))
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }

            ElevatedButton(
                onClick = {
                    expanded.value = expanded.value.not()
                },
            ) {
                Text(text = if (expanded.value) "show less" else "show more")
            }
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the basics codeLab")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = {
                onContinueClicked.invoke()
            }
        ) {
            Text(text = "Continue")
        }
    }
}

private fun extraPaddingBottomWhenExpanded(
    expanded: Boolean,
    @Dimension(unit = Dimension.DP)
    dp: Dp
) = if (expanded) dp else 0.dp

@Preview
@Composable
fun MyAppPreview() {
    ComposestudyTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposestudyTheme {
        Greetings()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposestudyTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    ComposestudyTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}