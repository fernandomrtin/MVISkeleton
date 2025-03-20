package training.presentation.feature.main

import training.model.menu.MenuElement
import training.model.menu.MenuOption
import training.model.menu.MenuType
import training.presentation.feature.main.navigation.NavRoutes

private fun menuSection(option: MenuOption, titleRes: Int, route: String) =
    MenuElement(option, titleRes, MenuType.Section(route))

private fun menuExternal(option: MenuOption, titleRes: Int, link: String) =
    MenuElement(option, titleRes, MenuType.ExternalWeb(link))

fun List<MenuOption>.toMenuElementList() = mapNotNull { option ->
    when (option) {
        MenuOption.HOME -> menuSection(option, training.ui.R.string.home, NavRoutes.Home.route)
        MenuOption.CALENDAR -> menuSection(option, training.ui.R.string.calendar, NavRoutes.Calendar.route)
        MenuOption.TICKETING -> menuExternal(option, training.ui.R.string.tickets, "www.google.es")
        MenuOption.HOSPITALITY -> menuSection(option, training.ui.R.string.hospitality, NavRoutes.Hospitality.route)
        MenuOption.TEAM -> menuSection(option, training.ui.R.string.team, NavRoutes.Team.route)
        MenuOption.STORE -> menuExternal(option, training.ui.R.string.store, "www.google.es")
        MenuOption.CLUB -> MenuElement(option, training.ui.R.string.club, MenuType.SubMenu)
        MenuOption.SUBSCRIBER_AREA -> menuSection(option, training.ui.R.string.subscriber_area, NavRoutes.SubscriberArea.route)
        MenuOption.CONFIGURATION -> MenuElement(option, training.ui.R.string.configuration, MenuType.SubMenu)
        MenuOption.HISTORY -> menuSection(option, training.ui.R.string.history, NavRoutes.History.route)
        MenuOption.STADIUM -> menuSection(option, training.ui.R.string.stadium, NavRoutes.Stadium.route)
        MenuOption.SPORTS_CITY -> menuSection(option, training.ui.R.string.sport_city, NavRoutes.SportsCity.route)
        MenuOption.FOUNDATION -> menuSection(option, training.ui.R.string.foundation, NavRoutes.Foundation.route)
        MenuOption.FANS -> menuSection(option, training.ui.R.string.groups, NavRoutes.Fans.route)
        MenuOption.INFERNO -> menuSection(option, training.ui.R.string.fans, NavRoutes.Inferno.route)
        MenuOption.CONTACT -> menuSection(option, training.ui.R.string.contact, NavRoutes.Contact.route)
        MenuOption.LANGUAGE -> menuSection(option, training.ui.R.string.language, NavRoutes.Language.route)
        MenuOption.NOTIFICATIONS -> MenuElement(option, training.ui.R.string.notifications, MenuType.SubMenu)
        MenuOption.SHARE_APP -> menuExternal(option, training.ui.R.string.share_app, "www.google.es")
        MenuOption.RATING_APP -> menuExternal(option, training.ui.R.string.rating_app, "www.google.es")
        MenuOption.TERMS_AND_CONDITIONS -> menuExternal(option, training.ui.R.string.terms_and_conditions, "www.google.es")
    }
}