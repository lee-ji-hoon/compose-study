package com.moview_app.component.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moview_app.ui.theme.MovieAppTheme
import com.moview_app.ui.theme.Paddings
import com.moview_app.ui.theme.movieColorSchemes
import com.moview_app.ui.theme.underlinedDialogButton

@Composable
fun UnderlineButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.movieColorSchemes.background,
            contentColor = MaterialTheme.movieColorSchemes.secondary,
            disabledContainerColor = MaterialTheme.movieColorSchemes.background,
            disabledContentColor = MaterialTheme.movieColorSchemes.disabledSecondary
        ),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.underlinedDialogButton,
                modifier = Modifier.padding(Paddings.small)
            )
        }
    }
}

@Preview
@Composable
fun UnderlineButtonPreview() {
    MovieAppTheme {
        UnderlineButton(
            text = "submit"
        ) {
        }
    }
}