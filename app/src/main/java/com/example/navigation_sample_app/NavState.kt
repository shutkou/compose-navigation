package com.example.navigation_sample_app

import AppDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberNavigationState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): NavState {
    return remember(
        coroutineScope,
    ) {
        NavState(
            navController = navController,
            //coroutineScope = coroutineScope
        )
    }
}


class NavState(
    val navController: NavHostController
) {

    private val previousDestination = mutableStateOf<NavDestination?>(null)


    val currentDestination: NavDestination?
        @Composable get() {
            // Collect the currentBackStackEntryFlow as a state
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

//    val currentTopLevelDestination: TopLevelDestination?
//        @Composable get() {
//            return topLevelDestinations.firstOrNull { topLevelDestination ->
//                currentDestination?.hasRoute(route = topLevelDestination.route, null) == true
//            }
//        }
//
//    /**
//     * UI logic for navigating to a top level destination in the app. Top level destinations have
//     * only one copy of the destination of the back stack, and save and restore state whenever you
//     * navigate to and from it.
//     *
//     * @param topLevelDestination: The destination the app needs to navigate to.
//     */
//    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
//            val topLevelNavOptions = navOptions {
//                // Pop up to the start destination of the graph to
//                // avoid building up a large stack of destinations
//                // on the back stack as users select items
//                popUpTo(navController.graph.findStartDestination().id) {
//                    saveState = true
//                }
//                // Avoid multiple copies of the same destination when
//                // reselecting the same item
//                launchSingleTop = true
//                // Restore state when reselecting a previously selected item
//                restoreState = true
//            }
//
//            when (val destination = topLevelDestination.destination) {
//                TopLevelDestination.FIRST_PARTY_EFT -> navController.navigateToFirstPartyEftRoute(topLevelNavOptions)
//                TopLevelDestination.THIRD_PARTY_EFT -> navController.navigateToThirdPartyEftRoute(topLevelNavOptions)
//                TopLevelDestination.THIRD_PARTY_WIRE -> navController.navigateToThirdPartyWireRoute(topLevelNavOptions)
//            }
//    }

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param route: The [AppDestination] the app needs to navigate to.
     */
    fun navigate(route: AppDestination) {

        if (route is AppDestination.Back) {
            onBackClick()
        } else if (route.isTopLevel) {
            navController.navigate(route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        } else {
            navController.navigate(route)
        }
    }

    private fun onBackClick() {
        navController.popBackStack()
    }
}