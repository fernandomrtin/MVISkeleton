package training.domain.bridge

import arrow.core.Either
import training.domain.usecase.monsters.GetMonsterFromIdUseCase
import training.model.failure.Failure
import training.domain.model.Monster
import javax.inject.Inject

interface DetailsBridge {
    suspend fun getMonster(monsterId: Int): Either<Failure, Monster>
}

class DetailsBridgeImpl @Inject constructor(
    private val getMonsterFromIdUseCase: GetMonsterFromIdUseCase
) : DetailsBridge {
    override suspend fun getMonster(monsterId: Int): Either<Failure, Monster> = getMonsterFromIdUseCase.invoke(monsterId)
}