package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun FirstPartyEftScreen(
    onNavigate: (AppDestination) -> Unit
) {
    FirstPartyEftScreen(
        onClose = {
            onNavigate(
                AppDestination.BSLanding
            )
        },
        onBack = {
            onNavigate(
                AppDestination.BSLanding
            )
        },
        onManual = {
            onNavigate(
                AppDestination.FirstPartyEFTManual
            )
        },
        onFinicity = {
            onNavigate(
                AppDestination.FirstPartyFinicity
            )
        }
    )
}

@Composable
private fun FirstPartyEftScreen(
    title: String = "First Party EFT",
    onClose: () -> Unit,
    onBack: () -> Unit,
    onManual: () -> Unit,
    onFinicity: () -> Unit
) {
    BaseScreen(title, onClose, onNext = null, onBack) {
        Column {
            Text("Go to manual", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onManual() })
            Text("Go to Finicity", style = MaterialTheme.typography.titleLarge, modifier = Modifier.clickable { onFinicity() })
        }
    }
}