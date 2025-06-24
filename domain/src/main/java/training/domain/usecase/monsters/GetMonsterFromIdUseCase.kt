package training.domain.usecase.monsters

import arrow.core.Either
import kotlinx.coroutines.coroutineScope
import training.domain.contract.MonstersRepository
import training.model.failure.Failure
import training.domain.model.Monster
import javax.inject.Inject

class GetMonsterFromIdUseCase @Inject constructor(
    private val monstersRepository: MonstersRepository
) {

    suspend operator fun invoke(monsterId: Int): Either<Failure, Monster> = coroutineScope {
        monstersRepository.getMonsterFromLocal(id = monsterId)
    }
}