package training.data.datasource.local

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import training.data.datasource.local.database.MonsterDao
import training.data.model.entity.MonsterEntity
import training.model.failure.Failure
import javax.inject.Inject

class MonstersLocalDatasource @Inject constructor(private val monsterDao: MonsterDao) {

    suspend fun getMonsterData(id: Int): Either<Failure, MonsterEntity> {
        val response = monsterDao.getMonsterById(id = id)
        return response?.right() ?: Failure.NoData.left()
    }
}