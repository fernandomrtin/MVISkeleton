package training.data.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import training.model.failure.Failure
import training.model.menu.MenuOption
import javax.inject.Inject

class MenuDatasource @Inject constructor() {

    fun getMainMenuOptionList(): Either<Failure, List<MenuOption>> =
        listOf(
            MenuOption.HOME,
            MenuOption.CALENDAR,
            MenuOption.TICKETING,
            MenuOption.HOSPITALITY,
            MenuOption.TEAM,
            MenuOption.STORE,
            MenuOption.CLUB,
            MenuOption.SUBSCRIBER_AREA,
            MenuOption.CONFIGURATION
        ).right()

    fun getSubMenuByOption(menuOption: MenuOption): Either<Failure, List<MenuOption>> =
        when (menuOption) {
            MenuOption.CLUB ->
                listOf(
                    MenuOption.HISTORY,
                    MenuOption.STADIUM,
                    MenuOption.SPORTS_CITY,
                    MenuOption.FOUNDATION,
                    MenuOption.FANS,
                    MenuOption.INFERNO,
                    MenuOption.CONTACT
                ).right()

            MenuOption.CONFIGURATION ->
                listOf(
                    MenuOption.LANGUAGE,
                    MenuOption.NOTIFICATIONS,
                    MenuOption.SHARE_APP,
                    MenuOption.RATING_APP,
                    MenuOption.TERMS_AND_CONDITIONS
                ).right()

            else -> Failure.InputParamsError("No Subsection found").left()
        }
}