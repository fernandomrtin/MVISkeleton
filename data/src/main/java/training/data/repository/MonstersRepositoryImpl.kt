package training.data.repository

import arrow.core.Either
import training.data.datasource.local.MonstersLocalDatasource
import training.data.datasource.remote.MonstersRemoteDatasource
import training.data.model.entity.toDomainModel
import training.data.model.mapper.toDomainModel
import training.domain.contract.MonstersRepository
import training.model.failure.Failure
import training.domain.model.Monster
import javax.inject.Inject

class MonstersRepositoryImpl @Inject constructor(
    private val monstersRemoteDatasource: MonstersRemoteDatasource,
    private val monstersLocalDatasource: MonstersLocalDatasource
): MonstersRepository {

    override suspend fun fetchMonsterData(id: Int) =
        monstersRemoteDatasource.getMonsterData(id).map { it.toDomainModel() }

    override suspend fun getMonsterFromLocal(id: Int): Either<Failure, Monster> =
        monstersLocalDatasource.getMonsterData(id).map { it.toDomainModel() }

}