package com.bosta_task.habittracker.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.login.components.LoginWithEmailDialog
import com.bosta_task.habittracker.login.model.LoginState
import java.nio.file.WatchEvent

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginState: LoginState,
    sendLoginEvent: (LoginEvent) -> Unit,
) {
    Box(
        modifier = modifier.background(color = MaterialTheme.colorScheme.tertiary),
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth(),
            painter = painterResource(
                id = R.drawable.login_background
            ),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(1f)
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Text(
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.welcome_to_monumental_habbit),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Button(
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            )
            {
                Row(Modifier.padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        modifier = Modifier
                            .size(25.dp)
                            .padding(top = 4.dp),
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(R.string.continue_with_google),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }
            Button(
                modifier = Modifier
                    .padding(bottom = 25.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            )
            {
                Row(
                    Modifier.padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(25.dp)
                            .padding(top = 4.dp),
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = ""
                    )
                    Text(text = stringResource(R.string.continue_with_facebook), style = MaterialTheme.typography.bodyMedium)
                }
            }
            LoginWithEmailDialog(
                modifier = Modifier.fillMaxWidth(),
                loginState = loginState,
                changeEmailValue = {
                    sendLoginEvent(LoginEvent.ChangeEmail(it))
                },
                changePasswordValue = {
                    sendLoginEvent(LoginEvent.ChangePassword(it))
                },
                showPassword = {
                    sendLoginEvent(LoginEvent.ForgetPasswordClicked)
                },
                onLogInClicked = {
                    sendLoginEvent(LoginEvent.LoginClicked)
                },
                navigateToForgetPassword = {
                    sendLoginEvent(LoginEvent.ForgetPasswordClicked)
                },
                navigateToSignUp = {
                    sendLoginEvent(LoginEvent.SignUpClicked)
                }
            )
        }
    }
}

@Preview
@Composable
fun LoginPrev() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                modifier = Modifier.fillMaxSize(),
                loginState = LoginState(),
                sendLoginEvent = {

                }
            )
        }
    }
}