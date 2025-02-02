package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun SuccessSummaryScreen(
    onNavigate: (AppDestination) -> Unit
) {
    SuccessSummaryScreen(
        onClose = { onNavigate(
            AppDestination.BSLanding
        ) },
        onTransfer = {}
    )
}

@Composable
private fun SuccessSummaryScreen(
    title: String = "Success Summary",
    onClose: () -> Unit,
    onTransfer: () -> Unit
) {
    BaseScreen(title, onClose = onClose) {
        Column {
            Text("Go to BS Landing screen", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onClose() })
            Text("Go to Transfer", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onTransfer() })
        }
    }
}