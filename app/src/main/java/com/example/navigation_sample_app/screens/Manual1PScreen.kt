package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.launch

@Composable
internal fun Manual1PScreen(
    navigator: Navigator
) {

    val coroutineScope = rememberCoroutineScope()

    Manual1PScreen(
        onClose = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.BSLanding
                )
            }
        },
        onNext = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.Review
                )
            }
        },
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
private fun Manual1PScreen(
    title: String = "Manual First Party",
    onClose: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseScreen(title, onClose, onNext, onBack)
}