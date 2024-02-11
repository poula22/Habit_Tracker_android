package com.bosta_task.habittracker.login

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.login.components.LoginWithEmailDialog
import com.bosta_task.habittracker.login.model.LoginState

@Composable
fun LoginScreen(
    modifier: Modifier,
    loginState: LoginState,
    sendLoginEvent: (LoginEvent) -> Unit
) {
    Box(
        modifier = modifier
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
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
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
                    .fillMaxWidth(), onClick = { /*TODO*/ })
            {
                Row {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = ""
                    )
                    Text(text = "Continue with google")
                }

            }
            Button(
                modifier = Modifier
                    .padding(bottom = 25.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(), onClick = { /*TODO*/ })
            {
                Row {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = ""
                    )
                    Text(text = "Continue with facebook")
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

@Preview(showSystemUi = true)
@Composable
fun LoginPrev() {
    MaterialTheme(colorScheme = MaterialTheme.colorScheme) {
        Surface() {
            LoginScreen(
                modifier = Modifier.fillMaxSize(),
                loginState = LoginState(),
                sendLoginEvent = {

                }
            )
        }
    }
}