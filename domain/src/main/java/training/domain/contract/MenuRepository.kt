package training.domain.contract

import arrow.core.Either
import training.model.failure.Failure
import training.domain.model.MenuOption

interface MenuRepository {
    fun getMainMenuOptionList(): Either<Failure, List<MenuOption>>
    fun getSubMenuByOption(menuOption: MenuOption): Either<Failure, List<MenuOption>>
}