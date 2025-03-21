package training.data.datasource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import training.data.model.entity.MonsterEntity

@Dao
interface MonsterDao {
    @Query("SELECT * FROM monsters WHERE id = :id")
    suspend fun getMonsterById(id: Int): MonsterEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonster(monster: MonsterEntity)
}