package com.example.navigation_sample_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.navigation_sample_app.ui.theme.NavigationsampleappTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navState = rememberNavigationState()
            val navigator = AppNavigator(startDestination = AppDestination.BSLanding)

            ObserveNavEvents(flow = navigator.state) { destination ->
                 navState.navigate(destination)
            }

            NavigationsampleappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val state by navState.navController.currentBackStack.collectAsState(null)

                    AppNavHost(
                        navState.navController,
                        state = state, // used for debugging - remove
                        navigator = navigator,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}