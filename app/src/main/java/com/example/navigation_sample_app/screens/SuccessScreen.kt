package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun SuccessScreen(
    onNavigate: (AppDestination) -> Unit
) {
    SuccessScreen(
        onClose = { onNavigate(
            AppDestination.BSLanding
        ) },
        onTransfer = {},
        onSummary = { onNavigate(
            AppDestination.SuccessSummary
        ) }
    )
}

@Composable
private fun SuccessScreen(
    title: String = "Success",
    onClose: () -> Unit,
    onSummary: () -> Unit,
    onTransfer: () -> Unit
) {
    BaseScreen(title, onClose = onClose) {
        Column {
            Text("Go to summary screen", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onSummary() })
            Text("Go to Transfer", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onTransfer() })
        }
    }
}