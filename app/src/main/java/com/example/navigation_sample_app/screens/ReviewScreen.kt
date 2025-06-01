package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.launch

@Composable
internal fun ReviewScreen(
    navigator: Navigator
) {
    val coroutineScope = rememberCoroutineScope()

    ReviewScreen(
        onClose = {
            coroutineScope.launch {
                navigator.navigate(
                AppDestination.BSLanding
            )
        }},
        onNext = {
            coroutineScope.launch {
                navigator.navigate(
                AppDestination.Success
            )
        }},
        onBack = {
            coroutineScope.launch {
                navigator.navigate(
                AppDestination.Back
            )
        }}
    )
}

@Composable
private fun ReviewScreen(
    title: String = "Review Screen",
    onClose: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseScreen(title, onClose, onNext, onBack)
}