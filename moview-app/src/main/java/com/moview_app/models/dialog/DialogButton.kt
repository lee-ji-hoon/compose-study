package com.moview_app.models.dialog

import com.moview_app.models.buttons.LeadingIconData

sealed interface DialogButton {

    val title: String
    val action: (() -> Unit)?

    data class Primary(
        override val title: String,
        val leadingIconData: LeadingIconData? = null,
        override val action: (() -> Unit)? = null
    ) : DialogButton

    data class Secondary(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton

    data class UnderlinedText(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton

    data class SecondaryBorderless(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton
}
