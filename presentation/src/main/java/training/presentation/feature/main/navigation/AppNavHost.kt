package training.presentation.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import training.presentation.feature.details.DetailsScreen
import training.presentation.feature.home.compose.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier, onBackPressed: () -> Unit = {}) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
        modifier = modifier
    ) {
        composable(NavRoutes.Home.route) {
            HomeScreen(
                onNavigateToDetails = { monsterId ->
                    navController.navigate(NavRoutes.Details.createRoute(monsterId))
                }
            )
        }

        composable(NavRoutes.Details.route) { backStackEntry ->
            val monsterId = backStackEntry.arguments?.getString("monsterId")?.toIntOrNull()
            DetailsScreen(monsterId = monsterId, onBackPressed = onBackPressed)
        }
    }
}
