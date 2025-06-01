package com.example.navigation_sample_app

import AppDestination
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface Navigator {
    val startDestination: AppDestination
    val state: Flow<NavigationEvent>

    suspend fun navigate(destination: AppDestination, navOptions: NavOptionsBuilder.() -> Unit = {})
    suspend fun back()
}

class AppNavigator(
    override val startDestination: AppDestination
) : Navigator {
    private val _state = Channel<NavigationEvent>()
    override val state: Flow<NavigationEvent> = _state.receiveAsFlow()

    override suspend fun navigate(
        destination: AppDestination,
        navOptions: NavOptionsBuilder.() -> Unit
    ) {
        _state.send(NavigationEvent.Navigate(destination, navOptions))
    }

    override suspend fun back() {
        _state.send(NavigationEvent.Back)
    }
}