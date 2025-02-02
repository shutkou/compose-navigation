package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable

@Composable
internal fun Finicity1PScreen(
    onNavigate: (AppDestination) -> Unit
) {
    Finicity1PScreen(
        onClose = {
            onNavigate(
                AppDestination.BSLanding
            )
        },
        onNext = {},
        onBack = {
            onNavigate(
                AppDestination.FirstPartyEft
            )
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