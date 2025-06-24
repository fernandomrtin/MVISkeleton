package training.domain.contract

import arrow.core.Either
import training.model.failure.Failure
import training.domain.model.Monster

interface MonstersRepository {
    suspend fun fetchMonsterData(id: Int): Either<Failure, Monster>
    suspend fun getMonsterFromLocal(id: Int): Either<Failure, Monster>
}