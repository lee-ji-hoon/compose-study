package com.moview_app.component.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
@Preview
fun CategoryRowPreview() {
    CategoryRow()
}