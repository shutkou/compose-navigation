import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigation_sample_app.Navigator
import com.example.navigation_sample_app.screens.FTFScreen
import com.example.navigation_sample_app.screens.Finicity1PScreen
import com.example.navigation_sample_app.screens.FirstPartyEftScreen
import com.example.navigation_sample_app.screens.LandingScreen
import com.example.navigation_sample_app.screens.Manual1PScreen
import com.example.navigation_sample_app.screens.ReviewScreen
import com.example.navigation_sample_app.screens.SuccessScreen
import com.example.navigation_sample_app.screens.SuccessSummaryScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestination(
    /**
     * indicates whether this is a top level route in the flow.
     * If set to true, all the child screens in the flow will be popped from the back stack.
     */
    val isTopLevel: Boolean = false
) {
    @Serializable
    data object BSLanding : AppDestination(isTopLevel = true) // route to Landing Screen

    @Serializable
    data object FirstPartyEft: AppDestination(isTopLevel = true) // route to FirstPartyEft Landing Screen

    @Serializable
    data object FirstPartyEftBase: AppDestination() // route to base navigation graph

    @Serializable
    data object FirstPartyEftFTF: AppDestination() // route to FirstThingFirst 1st Party EFT Screen

    @Serializable
    data object FirstPartyEFTManual: AppDestination() // route to Manual 1st party EFT screen

    @Serializable
    data object FirstPartyFinicity: AppDestination() // route to Manual 1st party EFT screen

    @Serializable
    data object ThirdPartyEft: AppDestination(isTopLevel = true) // route to FirstPartyEft screen

    @Serializable
    data object ThirdPartyEftBase: AppDestination() // route to base navigation graph

    @Serializable
    data object Review: AppDestination() // route to Review

    @Serializable
    data object Success: AppDestination() // route to Success

    @Serializable
    data object SuccessSummary: AppDestination() // route to Success Summary

    @Serializable
    data object Back: AppDestination() // back navigation
}

/**
 *  The Landing route of the app.
 *
 *  @param navigator - Called when a navigation event is fired on the screen
 */
fun NavGraphBuilder.landingRoute(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?
) {
    composable<AppDestination.BSLanding> {
        LandingScreen(navigator)
        DebugNavStateElement(currentNavState)
    }
}

/**
 *  The Success Summary route of the app.
 *
 *  @param navigator - Called when a navigation event is fired on the screen
 */
fun NavGraphBuilder.reviewRoute(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?
) {
    composable<AppDestination.Review> {
        ReviewScreen(navigator)
        DebugNavStateElement(currentNavState)
    }
}

/**
 *  The Success route of the app.
 *
 *  @param navigator - Called when a navigation event is fired on the screen
 */
fun NavGraphBuilder.successRoute(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?
) {
    composable<AppDestination.Success> {
        SuccessScreen(navigator)
        DebugNavStateElement(currentNavState)
    }
}

/**
 *  The Success Summary route of the app.
 *
 *  @param navigator - Called when a navigation event is fired on the screen
 */
fun NavGraphBuilder.successSummaryRoute(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?
) {
    composable<AppDestination.SuccessSummary> {
        SuccessSummaryScreen(navigator)
        DebugNavStateElement(currentNavState)
    }
}

/**
 *  The First Party Eft graph of the app.
 *
 *  @param onNavigate - Called when a navigation event is fired on the screen,
 *  takes [AppDestination] as an argument to navigate to.
 */
fun NavGraphBuilder.firstPartyEftGraph(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?,
    nestedRoutes: NavGraphBuilder.() -> Unit
) {
    navigation<AppDestination.FirstPartyEftBase>(startDestination = AppDestination.FirstPartyEft) {

        composable<AppDestination.FirstPartyEft> {
            FirstPartyEftScreen(navigator)
            DebugNavStateElement(currentNavState)
        }

        composable<AppDestination.FirstPartyEftFTF> {
            FTFScreen(navigator)
            DebugNavStateElement(currentNavState)
        }
        composable<AppDestination.FirstPartyEFTManual> {
            Manual1PScreen(navigator)
            DebugNavStateElement(currentNavState)
        }
        composable<AppDestination.FirstPartyFinicity> {
            Finicity1PScreen(navigator)
            DebugNavStateElement(currentNavState)
        }
        nestedRoutes()
    }
}

/**
 *  The Third Party Eft graph of the app.
 *
 *  @param navigator - Called when a navigation event is fired on the screen
 */
fun NavGraphBuilder.thirdPartyEftGraph(
    navigator: Navigator,
    currentNavState: List<NavBackStackEntry>?
) {
    navigation<AppDestination.ThirdPartyEftBase>(startDestination = AppDestination.ThirdPartyEft) {
        composable<AppDestination.ThirdPartyEft> {
            FTFScreen(navigator)
            DebugNavStateElement(currentNavState)
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun DebugNavStateElement(state: List<NavBackStackEntry>?) {
    Column {
        Spacer(modifier = Modifier.height(100.dp))
        state?.let { navBackStackEntries ->
            val backStack = StringBuilder("Back Stack:\n")
            navBackStackEntries.forEach {
                backStack.append(it.destination.route).append(" ->\n")
            }
            Text(backStack.toString(), style = MaterialTheme.typography.titleLarge)
        }
    }
}