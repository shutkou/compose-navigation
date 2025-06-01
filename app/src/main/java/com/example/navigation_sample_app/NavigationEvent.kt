package com.example.navigation_sample_app

import AppDestination
import androidx.navigation.NavOptionsBuilder

sealed interface NavigationEvent {
    data class Navigate(
        val destination: AppDestination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationEvent

    data object Back : NavigationEvent
}
