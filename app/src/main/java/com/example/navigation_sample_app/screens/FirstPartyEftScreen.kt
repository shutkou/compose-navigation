package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.launch

@Composable
internal fun FirstPartyEftScreen(
    navigator: Navigator
) {

    val coroutineScope = rememberCoroutineScope()

    FirstPartyEftScreen(
        onClose = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.BSLanding
                )
            }
        },
        onBack = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.BSLanding
                )
            }
        },
        onManual = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.FirstPartyEFTManual
                )
            }
        },
        onFinicity = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.FirstPartyFinicity
                )
            }
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
            Text(
                "Go to manual",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.clickable { onManual() })
            Text(
                "Go to Finicity",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.clickable { onFinicity() })
        }
    }
}