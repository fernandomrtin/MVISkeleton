package training.domain.usecase.menu

import arrow.core.Either
import training.domain.contract.MenuRepository
import training.model.failure.Failure
import training.model.menu.MenuOption
import javax.inject.Inject

class GetMenuOptionListUseCase @Inject constructor(
    private val menuRepository: MenuRepository
) {

    operator fun invoke(menuOption: MenuOption? = null): Either<Failure, List<MenuOption>> =
        menuOption?.let {
            menuRepository.getSubMenuByOption(it)
        } ?: run {
            menuRepository.getMainMenuOptionList()
        }
}