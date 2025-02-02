package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LandingScreen(onNavigate: (AppDestination) -> Unit) {

    BaseScreen(title = "Landing Screen", onClose = {}, onNext = null, onBack = null) {
        Column {
            Button(
                onClick = { onNavigate(AppDestination.FirstPartyEft) },
            ) { Text("First Party EFT", style = MaterialTheme.typography.titleLarge) }

            Button(
                onClick = { onNavigate(AppDestination.ThirdPartyEft) },
            ) { Text("Third Party EFT", style = MaterialTheme.typography.titleLarge) }

            Button(
                onClick = { },
            ) { Text("Third Party Wire", style = MaterialTheme.typography.titleLarge) }
        }
    }
}