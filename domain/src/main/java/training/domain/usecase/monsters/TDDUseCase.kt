package training.domain.usecase.monsters

import arrow.core.Either
import arrow.core.right
import kotlinx.coroutines.coroutineScope
import training.domain.contract.MonstersRepository
import training.domain.model.Monster
import training.model.failure.Failure
import javax.inject.Inject

class TDDUseCase @Inject constructor(
    private val monstersRepository: MonstersRepository
) {

    suspend operator fun invoke(monster: Monster): Either<Failure, Int> = coroutineScope {
        (29+1).right()
    }
}