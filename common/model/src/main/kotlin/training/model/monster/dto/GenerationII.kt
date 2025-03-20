package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationII (

    @SerialName("crystal" ) var crystal : Crystal? = Crystal(),
    @SerialName("gold"    ) var gold    : Gold?    = Gold(),
    @SerialName("silver"  ) var silver  : Silver?  = Silver()

)