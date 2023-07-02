package com.moview_app.component.dialog.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.moview_app.component.buttons.PrimaryButton
import com.moview_app.component.buttons.SecondaryBorderlessButton
import com.moview_app.component.buttons.SecondaryButton
import com.moview_app.component.buttons.UnderlineButton
import com.moview_app.models.dialog.DialogButton
import com.moview_app.ui.theme.Paddings

@Composable
fun DialogButtonColumn(
    buttons: List<DialogButton>?
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttons?.forEachIndexed { index, dialogButton ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(Paddings.large))
            }

            when (dialogButton) {
                is DialogButton.Primary -> {
                    PrimaryButton(
                        text = dialogButton.title,
                        leadingIconData = dialogButton.leadingIconData
                    ) {
                        dialogButton.action?.invoke()
                    }
                }

                is DialogButton.Secondary -> {
                    SecondaryButton(
                        text = dialogButton.title,
                    ) {
                        dialogButton.action?.invoke()
                    }
                }

                is DialogButton.SecondaryBorderless -> {
                    SecondaryBorderlessButton(
                        text = dialogButton.title,
                    ) {
                        dialogButton.action?.invoke()
                    }
                }

                is DialogButton.UnderlinedText -> {
                    UnderlineButton(
                        text = dialogButton.title,
                    ) {
                        dialogButton.action?.invoke()
                    }
                }
            }
        }
    }
}