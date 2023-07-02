package com.moview_app.component.dialog

import androidx.compose.runtime.Composable
import com.moview_app.models.dialog.DialogButton
import com.moview_app.models.dialog.DialogContent
import com.moview_app.models.dialog.DialogText
import com.moview_app.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}