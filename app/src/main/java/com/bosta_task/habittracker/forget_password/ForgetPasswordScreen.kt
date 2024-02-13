package com.bosta_task.habittracker.forget_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.core.ui.theme.Fog

@Composable
fun ForgetPasswordScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Icon(
            modifier = Modifier
                .background(Fog, RoundedCornerShape(100))
                .clip(RoundedCornerShape(100))
                .size(40.dp)
                .align(Alignment.TopStart),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = ""
        )
        Column(modifier = Modifier.padding(top = 24.dp).aspectRatio(0.5f).align(Alignment.TopCenter)) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(R.string.forget_your_password),
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                painter = painterResource(id = R.drawable.forget_password),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun ForgetPasswordPrev() {
    MaterialTheme {
        Surface {
            ForgetPasswordScreen(Modifier.fillMaxSize())
        }
    }
}