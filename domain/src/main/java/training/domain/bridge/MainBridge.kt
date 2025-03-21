package training.domain.bridge

import arrow.core.Either
import training.domain.usecase.menu.GetMenuOptionListUseCase
import training.model.failure.Failure
import training.model.menu.MenuOption
import javax.inject.Inject

interface MainBridge {
    suspend fun getMenuListByOption(option: MenuOption?): Either<Failure, List<MenuOption>>
}

class MainBridgeImpl @Inject constructor(
    private val getMenuOptionListUseCase: GetMenuOptionListUseCase
) : MainBridge {

    override suspend fun getMenuListByOption(option: MenuOption?): Either<Failure, List<MenuOption>> =
        getMenuOptionListUseCase.invoke(option)

}