package training.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import training.domain.model.Monster

@Entity(tableName = "monsters")
data class MonsterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String
)

fun MonsterEntity.toDomainModel() = Monster(id = id, name = name, imageUrl = imageUrl)
fun Monster.toEntity() = MonsterEntity(id = id, name = name ?: "", imageUrl = imageUrl ?: "")