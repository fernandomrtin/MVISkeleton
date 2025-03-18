package training.presentation.feature.main.navigation

sealed class NavRoutes(val route: String) {
    data object Home : NavRoutes("home")
    data object Details : NavRoutes("details/{userId}") {
        fun createRoute(userId: Int) = "details/$userId"
    }
}