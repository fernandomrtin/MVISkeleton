package training.domain.model

data class Monster(
    var id: Int,
    var name: String? = null,
    var baseExperience: Int? = null,
    var imageUrl: String? = null
)