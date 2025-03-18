package training.presentation.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import training.presentation.feature.details.DetailsScreen
import training.presentation.feature.home.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier, onBackPressed: () -> Unit = {}) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
        modifier = modifier
    ) {
        composable(NavRoutes.Home.route) {
            HomeScreen(
                onNavigateToDetails = { userId ->
                    navController.navigate(NavRoutes.Details.createRoute(userId))
                }
            )
        }

        composable(NavRoutes.Details.route) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull()
            DetailsScreen(userId = userId, onBackPressed = onBackPressed)
        }
    }
}
