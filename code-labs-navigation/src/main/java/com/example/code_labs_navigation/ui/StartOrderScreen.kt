package com.example.code_labs_navigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.code_labs_navigation.R
import com.example.code_labs_navigation.ui.theme.ComposeStudyTheme

@Composable
fun StartOrderScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = "cupcake image"
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(id = R.string.one_cupcake))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(id = R.string.six_cupcakes))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(id = R.string.twelve_cupcakes))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CupcakeScreenPreview() {
    ComposeStudyTheme {
        StartOrderScreen()
    }
}