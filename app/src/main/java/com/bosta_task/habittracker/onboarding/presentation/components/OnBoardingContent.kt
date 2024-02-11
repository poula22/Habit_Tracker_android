package com.bosta_task.habittracker.onboarding.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R

@Composable
fun OnBoardingContent(
    @StringRes header: Int,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(
            top = 60.dp,
            start = 8.dp,
            end = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = header),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Image(
            painter = painterResource(id = imageId), contentDescription = "",
            modifier = Modifier
                .fillMaxSize(0.8f)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(MaterialTheme.colorScheme.onPrimary)) {
                    append("WE CAN ")
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("HELP YOU ")
                }
                withStyle(style = SpanStyle(MaterialTheme.colorScheme.onPrimary)) {
                    append("TO BE A BETTER\n")
                }
                withStyle(style = SpanStyle(MaterialTheme.colorScheme.onPrimary)) {
                    append("VERSION OF YOURSELF")
                }
            },
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ContentPreview() {
    MaterialTheme {
        Surface {
            OnBoardingContent(
                header = R.string.join_a_supportive_community,
                imageId = R.drawable.on_boarding_0
            )
        }
    }

}