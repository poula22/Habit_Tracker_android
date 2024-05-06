package com.bosta_task.habittracker.navigation

sealed interface NavigationEvent {
    data class Navigate(val route: String):NavigationEvent
    data object NavigateUp: NavigationEvent
}