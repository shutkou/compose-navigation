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
    onNavigate: (AppDestination) -> Unit,
    startDestination: Any = AppDestination.BSLanding,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
    ) {
        landingRoute(onNavigate, state)
        firstPartyEftGraph(onNavigate, state) {
            reviewRoute(onNavigate, state)
            successRoute(onNavigate, state)
            successSummaryRoute(onNavigate, state)
        }
        thirdPartyEftGraph(onNavigate, state)
    }
}