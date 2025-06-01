package com.example.navigation_sample_app

import AppDestination
import android.annotation.SuppressLint
import successRoute
import successSummaryRoute
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import firstPartyEftGraph
import landingRoute
import reviewRoute
import thirdPartyEftGraph

@SuppressLint("RestrictedApi")
@Composable
fun AppNavHost(
    navController: NavHostController,
    state: List<NavBackStackEntry>?,
    navigator: Navigator,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = navigator.startDestination,
        modifier = Modifier
    ) {
        landingRoute(navigator, state)
        firstPartyEftGraph(navigator, state) {
            reviewRoute(navigator, state)
            successRoute(navigator, state)
            successSummaryRoute(navigator, state)
        }
        thirdPartyEftGraph(navigator, state)
    }
}