package com.moview_app.models.dialog

sealed interface DialogTitle {
    val text: String

    data class Default(
        override val text: String
    ) : DialogTitle

    data class Header(
        override val text: String
    ) : DialogTitle

    data class Large(
        override val text: String
    ) : DialogTitle
}
