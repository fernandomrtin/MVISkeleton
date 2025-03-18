package training.domain.contract

import arrow.core.Either
import training.model.failure.Failure
import training.model.menu.MenuOption

interface MenuRepository {
    fun getMainMenuOptionList(): Either<Failure, List<MenuOption>>
    fun getSubMenuByOption(menuOption: MenuOption): Either<Failure, List<MenuOption>>
}