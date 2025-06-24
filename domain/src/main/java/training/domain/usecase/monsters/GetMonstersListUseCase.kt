package training.domain.usecase.monsters

import arrow.core.Either
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import training.domain.contract.MonstersRepository
import training.model.failure.Failure
import training.domain.model.Monster
import javax.inject.Inject
import kotlin.random.Random

class GetMonstersListUseCase @Inject constructor(
    private val monstersRepository: MonstersRepository
) {

    suspend operator fun invoke(): Either<Failure, List<Monster>> = coroutineScope {
        val randomNumbers = List(10) { Random.nextInt(1, 351) }
        val results = randomNumbers.map { monsterNumber ->
            async {
                monstersRepository.fetchMonsterData(monsterNumber)
            }
        }.awaitAll()
        val failures = results.filterIsInstance<Either.Left<Failure>>()
        val successes = results.filterIsInstance<Either.Right<Monster>>().map { it.value }

        return@coroutineScope when {
            failures.isNotEmpty() -> Either.Left(failures.first().value)
            else -> Either.Right(successes)
        }
    }
}