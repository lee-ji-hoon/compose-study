package com.moview_app.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.moview_app.component.dialog.components.button.DialogButtonColumn
import com.moview_app.component.dialog.components.content.DialogContentWrapper
import com.moview_app.component.dialog.components.title.DialogTitleWrapper
import com.moview_app.models.dialog.DialogButton
import com.moview_app.models.dialog.DialogContent
import com.moview_app.models.dialog.DialogTitle
import com.moview_app.ui.theme.Paddings
import com.moview_app.ui.theme.movieColorSchemes

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.movieColorSchemes.background
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge
                    )
            ) {
                dialogContent?.let { DialogContentWrapper(it) }
                buttons?.let { DialogButtonColumn(it) }
            }
        }
    }
}
