package com.bosta_task.habittracker.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bosta_task.habittracker.R
import com.bosta_task.habittracker.forget_password.ForgetPasswordScreen
import com.bosta_task.habittracker.login.LoginScreen
import com.bosta_task.habittracker.login.LoginViewModel
import com.bosta_task.habittracker.onBoarding.presentation.OnBoardingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController() //create nav controller by rememberNavController
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var isBottomNavVisible by rememberSaveable { mutableStateOf(true) }

    isBottomNavVisible = when (navBackStackEntry?.destination?.route) {
        Routes.LOGIN -> false
        Routes.FORGET_PASSWORD -> false
        Routes.ON_BOARDING -> true
        else -> true
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(navController, isBottomNavVisible)
        }
    ) {padding->
        NavHost(
            navController = navController,
            startDestination = Routes.ON_BOARDING,
            modifier = Modifier.padding(padding),
        ) {
            composable(
                route = Routes.ON_BOARDING,
            ) {
                OnBoardingScreen(
                    onNavigation = navController::navigateOnEvent
                )
            }
            
            composable(
                route = Routes.LOGIN
            ) {
                val loginViewModel = hiltViewModel<LoginViewModel>()
                val loginState by loginViewModel.loginState.collectAsState()
                LoginScreen(
                    loginState = loginState,
                    sendLoginEvent = {
                        loginViewModel.onEvent(it)
                    }
                )
            }

            composable(
                route = Routes.FORGET_PASSWORD
            ) {
                ForgetPasswordScreen()
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController, bottomNavVisible: Boolean) {
    AnimatedVisibility(
        visible = bottomNavVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        if (currentDestination?.hierarchy?.any { it.route == "login" } == false) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart),
                    painter = painterResource(id = R.drawable.bottom_bar),
                    contentDescription = "bottom bar"
                )
                BottomAppBar (
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFFFF5FA)
                ){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_courses),
                            contentDescription = "courses"
                        )
                    }
                }
            }
        }
    }
}

fun NavHostController.navigateOnEvent(event:NavigationEvent) {
    when(event) {
        is NavigationEvent.Navigate -> navigate(event.route)
        NavigationEvent.NavigateUp -> navigateUp()
    }
}
