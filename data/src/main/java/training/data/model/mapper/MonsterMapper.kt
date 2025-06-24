package training.data.model.mapper

import training.data.model.dto.MonsterDto
import training.domain.model.Monster

fun MonsterDto.toDomainModel(): Monster {
    return Monster(
        id = id ?: 0,
        name = name,
        baseExperience = baseExperience,
        imageUrl = sprites?.other?.officialArtwork?.frontDefault
    )
}