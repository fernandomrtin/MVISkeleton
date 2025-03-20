package training.domain.bridge

import arrow.core.Either
import training.domain.usecase.menu.GetMenuOptionListUseCase
import training.domain.usecase.monsters.GetMonstersListUseCase
import training.model.failure.Failure
import training.model.menu.MenuOption
import training.model.monster.domain.Monster
import javax.inject.Inject

interface MainBridge {
    suspend fun getMenuListByOption(option: MenuOption?): Either<Failure, List<MenuOption>>
    suspend fun getMonstersList(): Either<Failure, List<Monster>>
}

class MainBridgeImpl @Inject constructor(
    private val getMenuOptionListUseCase: GetMenuOptionListUseCase,
    private val getMonstersListUseCase: GetMonstersListUseCase
) : MainBridge {

    override suspend fun getMenuListByOption(option: MenuOption?): Either<Failure, List<MenuOption>> =
        getMenuOptionListUseCase.invoke(option)

    override suspend fun getMonstersList(): Either<Failure, List<Monster>> =
        getMonstersListUseCase.invoke()

}