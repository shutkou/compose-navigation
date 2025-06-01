package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.launch

@Composable
fun LandingScreen(navigator: Navigator) {
    val coroutineScope = rememberCoroutineScope()

    BaseScreen(title = "Landing Screen", onClose = {}, onNext = null, onBack = null) {
        Column {
            Button(
                onClick = {
                    coroutineScope.launch {
                        navigator.navigate(AppDestination.FirstPartyEft)
                    }
                },
            ) { Text("First Party EFT", style = MaterialTheme.typography.titleLarge) }

            Button(
                onClick = {
                    coroutineScope.launch {
                        navigator.navigate(AppDestination.ThirdPartyEft)
                    }
                },
            ) { Text("Third Party EFT", style = MaterialTheme.typography.titleLarge) }

            Button(
                onClick = { },
            ) { Text("Third Party Wire", style = MaterialTheme.typography.titleLarge) }
        }
    }
}