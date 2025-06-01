package com.example.navigation_sample_app

import AppDestination
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface Navigator {
    val startDestination: AppDestination
    val state: Flow<AppDestination>

    suspend fun navigate(destination: AppDestination)
}

class AppNavigator(
    override val startDestination: AppDestination
) : Navigator {
    private val _state = Channel<AppDestination>()
    override val state: Flow<AppDestination> = _state.receiveAsFlow()

    override suspend fun navigate(
        destination: AppDestination,
    ) = _state.send(destination)
}