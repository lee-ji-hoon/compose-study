package com.moview_app.component.dialog.components.title

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.moview_app.models.dialog.DialogTitle
import com.moview_app.ui.theme.Paddings
import com.moview_app.ui.theme.movieColorSchemes

@Composable
fun DialogTitleWrapper(title: DialogTitle) {
    when (title) {
        is DialogTitle.Default -> {
            DefaultDialogTitle(title)
        }

        is DialogTitle.Large -> {
            LargeDialogTitle(title)
        }

        is DialogTitle.Header -> {
            HeaderDialogTitle(title)
        }
    }
}


@Composable
fun DefaultDialogTitle(title: DialogTitle.Default) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(
                horizontal = Paddings.large,
                vertical = Paddings.extra
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            title.text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Composable
fun LargeDialogTitle(title: DialogTitle.Large) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title.text,
            modifier = Modifier
                .padding(all = Paddings.xlarge)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun HeaderDialogTitle(title: DialogTitle.Header) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.movieColorSchemes.primary)
            .padding(Paddings.large),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title.text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.movieColorSchemes.onPrimary
            )
        )
    }
}
