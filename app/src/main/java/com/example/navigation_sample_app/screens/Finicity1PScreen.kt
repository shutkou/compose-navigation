package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.launch

@Composable
internal fun Finicity1PScreen(
    navigator: Navigator
) {
    val coroutineScope = rememberCoroutineScope()

    Finicity1PScreen(
        onClose = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.BSLanding
                )
            }
        },
        onNext = {},
        onBack = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.FirstPartyEft
                )
            }
        }
    )
}

@Composable
private fun Finicity1PScreen(
    title: String = "Finicity First Party",
    onClose: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseScreen(title, onClose, onNext, onBack)
}