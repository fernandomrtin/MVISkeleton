package training.data.datasource.local

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import training.model.failure.Failure
import training.domain.model.MenuOption
import javax.inject.Inject

class MenuLocalDatasource @Inject constructor() {

    fun getMainMenuOptionList(): Either<Failure, List<MenuOption>> =
        listOf(
            MenuOption.HOME
        ).right()

    fun getSubMenuByOption(menuOption: MenuOption): Either<Failure, List<MenuOption>> =
        when (menuOption) {
            MenuOption.HOME ->
                listOf(
                    MenuOption.HOME
                ).right()

            else -> Failure.InputParamsError("No Subsection found").left()
        }
}