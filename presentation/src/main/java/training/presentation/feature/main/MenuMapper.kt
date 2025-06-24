package training.presentation.feature.main

import training.domain.model.MenuElement
import training.domain.model.MenuOption
import training.domain.model.MenuType
import training.presentation.feature.main.navigation.NavRoutes

private fun menuSection(option: MenuOption, titleRes: Int, route: String) =
    MenuElement(option, titleRes, MenuType.Section(route))

private fun menuExternal(option: MenuOption, titleRes: Int, link: String) =
    MenuElement(option, titleRes, MenuType.ExternalWeb(link))

fun List<MenuOption>.toMenuElementList() = mapNotNull { option ->
    when (option) {
        MenuOption.HOME -> menuSection(option, training.ui.R.string.home, NavRoutes.Home.route)
       // MenuOption.TICKETING -> menuExternal(option, training.ui.R.string.tickets, "www.google.es")
       //MenuOption.CLUB -> MenuElement(option, training.ui.R.string.club, MenuType.SubMenu)
    }
}