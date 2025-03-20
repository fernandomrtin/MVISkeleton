package training.model.monster.domain

import training.model.monster.dto.MonsterDto

data class Monster(
    var id: Int? = null,
    var name: String? = null,
    var baseExperience: Int? = null,
)

fun MonsterDto.toMonster() = Monster(id = id, name = name, baseExperience = baseExperience)