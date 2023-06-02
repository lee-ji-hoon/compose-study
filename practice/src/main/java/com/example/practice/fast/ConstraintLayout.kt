package com.example.practice.fast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun EzConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (redBox, magentaBox, greenBox, yellowBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    start.linkTo(magentaBox.start, margin = 8.dp)
                    bottom.linkTo(magentaBox.bottom, margin = 8.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    centerTo(parent)
                }
        )
    }
}

@Composable
fun EzConstraintSet() {

    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start, margin = 8.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }

        constrain(greenBox) {
            start.linkTo(magentaBox.start, margin = 8.dp)
            bottom.linkTo(magentaBox.bottom, margin = 8.dp)
        }

        constrain(yellowBox) {
            centerTo(parent)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
        )
    }
}

@Composable
fun EzConstraintLayout2() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (redBox, magentaBox, greenBox, yellowBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 8.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    top.linkTo(parent.top, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 12.dp)
                }
        )

//        createVerticalChain(redBox, magentaBox, greenBox, yellowBox)
        createHorizontalChain(
            redBox, magentaBox, greenBox, yellowBox,
            chainStyle = ChainStyle.SpreadInside
        )
        val barrier = createBottomBarrier(redBox, magentaBox, greenBox, yellowBox)
        Text(
            text = "이지훈",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrier)
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ExConstraintLayout2Preview() {
    ComposestudyTheme {
        EzConstraintLayout2()
    }
}

@Composable
@Preview(showBackground = true)
fun ExConstraintLayoutPreview() {
    ComposestudyTheme {
        EzConstraintLayout()
    }
}

@Composable
@Preview(showBackground = true)
fun EzConstraintSetPreview() {
    ComposestudyTheme {
        EzConstraintSet()
    }
}