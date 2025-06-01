package com.example.navigation_sample_app.screens

import AppDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.navigation_sample_app.Navigator
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun FTFScreen(
    navigator: Navigator
) {
    val coroutineScope = rememberCoroutineScope()

    FTFScreen(
        onClose = {
            coroutineScope.launch {
                navigator.navigate(

                    AppDestination.BSLanding
                )

            }
        },
        onNext = {},
        onBack = {
            coroutineScope.launch {
                navigator.navigate(
                    AppDestination.BSLanding
                )
            }
        }
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