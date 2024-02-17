package com.bosta_task.habittracker.forget_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.core.ui.theme.Fog

@Composable
fun ForgetPasswordScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.background(color = MaterialTheme.colorScheme.primary)) {
        Icon(
            modifier = Modifier
                .padding(top = 20.dp, start = 8.dp)
                .background(Fog, RoundedCornerShape(100))
                .padding(4.dp)
                .clip(RoundedCornerShape(100))
                .size(30.dp)
                .align(Alignment.TopStart),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .padding(top = 80.dp)
                .aspectRatio(0.5f)
                .align(Alignment.TopCenter)
        ) {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(color = Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.enter_your_registered_email_below_to_receive_password_reset_instruction),
                    textAlign = TextAlign.Center
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    value = "", onValueChange = { }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(8.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = stringResource(R.string.send_reset_link))
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 34.dp)
        ) {
            Text(text = stringResource(R.string.remember_password))
            Text(
                text = "Login", style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
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