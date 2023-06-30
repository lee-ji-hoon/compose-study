package com.moview_app.component.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moview_app.ui.theme.MovieAppTheme
import com.moview_app.ui.theme.Paddings

@Composable
fun CategoryRow() {
    Column(

    ) {
        CategoryTitle(titleName = "Action")

        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
//            itemsIndexed()

            repeat(100) {
                item {
                    MovieItem()
                }
            }
        }
    }
}

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text = titleName,
        modifier = Modifier
            .padding(
                vertical = Paddings.large,
                horizontal = Paddings.extra
            ),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    MovieAppTheme {
        CategoryRow()
    }
}