package training.domain.contract

import arrow.core.Either
import training.model.failure.Failure
import training.model.monster.domain.Monster

interface MonstersRepository {
    suspend fun getMonsterData(id: Int): Either<Failure, Monster>
}