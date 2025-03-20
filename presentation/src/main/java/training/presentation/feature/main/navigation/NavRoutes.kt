package training.presentation.feature.main.navigation

sealed class NavRoutes(val route: String) {
    data object Home : NavRoutes("home")
    data object Calendar : NavRoutes("calendar")
    data object Hospitality : NavRoutes("hospitality")
    data object Team : NavRoutes("team")
    data object SubscriberArea : NavRoutes("subscriber_area")
    data object History : NavRoutes("history")
    data object Stadium : NavRoutes("stadium")
    data object SportsCity : NavRoutes("sports_city")
    data object Foundation : NavRoutes("foundation")
    data object Fans : NavRoutes("fans")
    data object Inferno : NavRoutes("inferno")
    data object Contact : NavRoutes("contact")
    data object Language : NavRoutes("language")
    data object Details : NavRoutes("details/{userId}") {
        fun createRoute(userId: Int) = "details/$userId"
    }
}