package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class VersionGroupDetails (

    @SerialName("level_learned_at"  ) var levelLearnedAt  : Int?             = null,
    @SerialName("version_group"     ) var versionGroup    : VersionGroup?    = VersionGroup(),
    @SerialName("move_learn_method" ) var moveLearnMethod : MoveLearnMethod? = MoveLearnMethod()

)