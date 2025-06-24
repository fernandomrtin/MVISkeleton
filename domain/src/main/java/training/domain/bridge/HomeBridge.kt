package training.domain.bridge

import arrow.core.Either
import training.domain.usecase.monsters.GetMonstersListUseCase
import training.model.failure.Failure
import training.domain.model.Monster
import javax.inject.Inject

interface HomeBridge {
    suspend fun getMonstersList(): Either<Failure, List<Monster>>
}

class HomeBridgeImpl @Inject constructor(
    private val getMonstersListUseCase: GetMonstersListUseCase
) : HomeBridge {

    override suspend fun getMonstersList(): Either<Failure, List<Monster>> =
        getMonstersListUseCase.invoke()

}