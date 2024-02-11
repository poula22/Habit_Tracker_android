package com.bosta_task.habittracker.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.login.model.LoginState

@Composable
fun LoginWithEmailDialog(
    modifier: Modifier = Modifier,
    loginState: LoginState,
    changeEmailValue: (String) -> Unit,
    changePasswordValue: (String) -> Unit,
    showPassword: () -> Unit,
    onLogInClicked: () -> Unit,
    navigateToForgetPassword: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color = Color.White, shape = MaterialTheme.shapes.medium)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 12.dp),
            text = stringResource(R.string.login_with_email),
            style = MaterialTheme.typography.bodySmall
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 1.dp
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 20.dp, start = 20.dp),
            value = loginState.email ?: "",
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_email), contentDescription = ""
                )
            },
            onValueChange = changeEmailValue
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 1.dp, end = 20.dp, start = 20.dp),
            value = loginState.password ?: "",
            leadingIcon = {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_password
                    ),
                    contentDescription = ""
                )
            },
            onValueChange = changePasswordValue
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = onLogInClicked
        ) {
            Text(
                text = stringResource(R.string.login)
            )
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally).clickable {
                navigateToForgetPassword()
            },
            text = stringResource(R.string.forget_password)
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 6.dp)) {
            Text(
                text = stringResource(R.string.don_t_have_an_account)
            )
            Text(
                modifier = Modifier.clickable {
                    navigateToSignUp()
                },
                text = stringResource(R.string.sign_up)
            )
        }
    }
}