package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable

@Composable
internal fun ReviewScreen(
    onNavigate: (AppDestination) -> Unit
) {
    ReviewScreen(
        onClose = {
            onNavigate(
                AppDestination.BSLanding
            )
        },
        onNext = {
            onNavigate(
                AppDestination.Success
            )
        },
        onBack = {
            onNavigate(
                AppDestination.Back
            )
        }
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