package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable

@Composable
internal fun FTFScreen(
    onNavigate: (AppDestination) -> Unit
) {
    FTFScreen(
        onClose = { onNavigate(
            AppDestination.BSLanding
        ) },
        onNext = {},
        onBack = { onNavigate(
            AppDestination.BSLanding
        ) }
    )
}

@Composable
private fun FTFScreen(
    title: String = "First Thing First",
    onClose: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseScreen(title, onClose, onNext, onBack)
}