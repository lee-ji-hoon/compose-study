package com.example.chapter04

import androidx.compose.foundation.clickable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.chapter04.ui.theme.ComposestudyTheme

@Composable
fun CheckboxWithLabelConstraint(
    label: String,
    state: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {

    ConstraintLayout(
        modifier = modifier.clickable {
            state.value = state.value.not()
        }
    ) {
        val (checkbox, text) = createRefs()
        Checkbox(
            checked = state.value,
            onCheckedChange = {
                state.value = it
            },
            modifier = Modifier.constrainAs(checkbox) { }
        )
        Text(
            text = label,
            modifier = Modifier.constrainAs(text) {
                start.linkTo(checkbox.end, margin = 8.dp)
                top.linkTo(checkbox.top)
                bottom.linkTo(checkbox.bottom)
            }
        )
    }
}

@Composable
@Preview(widthDp = 100, heightDp = 100)
fun CheckboxWithLabelConstraintPreview() {
    val state = remember {
        mutableStateOf(false)
    }
    ComposestudyTheme {
        CheckboxWithLabelConstraint(
            label = "red",
            state = state
        )
    }
}