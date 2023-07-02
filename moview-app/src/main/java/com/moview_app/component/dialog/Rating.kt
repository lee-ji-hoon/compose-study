package com.moview_app.component.dialog

import androidx.compose.runtime.Composable
import com.moview_app.models.dialog.DialogButton
import com.moview_app.models.dialog.DialogContent
import com.moview_app.models.dialog.DialogText
import com.moview_app.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}