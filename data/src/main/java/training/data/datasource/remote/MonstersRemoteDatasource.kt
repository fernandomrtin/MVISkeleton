package training.data.datasource.remote

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import retrofit2.Retrofit
import training.data.service.MonstersService
import training.model.failure.Failure
import training.data.model.dto.MonsterDto
import javax.inject.Inject

class MonstersRemoteDatasource @Inject constructor(
    retrofit: Retrofit
) {

    private val monstersService = retrofit.create(MonstersService::class.java)

    suspend fun getMonsterData(id: Int): Either<Failure, MonsterDto> {
        val response = monstersService.getMonsterData(id)
        return if (response.isSuccessful) {
            response.body()?.right() ?: Failure.NoData.left()
        } else {
            Failure.NoData.left()
        }
    }
}