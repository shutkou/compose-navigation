package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable

@Composable
internal fun Manual1PScreen(
    onNavigate: (AppDestination) -> Unit
) {
    Manual1PScreen(
        onClose = { onNavigate(
            AppDestination.BSLanding
        ) },
        onNext = {onNavigate(
            AppDestination.Review
        )},
        onBack = { onNavigate(
            AppDestination.FirstPartyEft
        ) }
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