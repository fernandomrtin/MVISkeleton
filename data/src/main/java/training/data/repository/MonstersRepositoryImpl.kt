package training.data.repository

import training.data.datasource.MonstersDatasource
import training.domain.contract.MonstersRepository
import training.model.monster.domain.toMonster
import javax.inject.Inject

class MonstersRepositoryImpl @Inject constructor(
    private val monstersDatasource: MonstersDatasource
): MonstersRepository {

    override suspend fun getMonsterData(id: Int) =
        monstersDatasource.getMonsterData(id).map { it.toMonster() }

}