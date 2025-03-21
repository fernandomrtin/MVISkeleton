package training.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import training.data.model.entity.MonsterEntity

@Database(entities = [MonsterEntity::class], version = 1)
abstract class MonsterDatabase : RoomDatabase() {
    abstract fun monsterDao(): MonsterDao
}