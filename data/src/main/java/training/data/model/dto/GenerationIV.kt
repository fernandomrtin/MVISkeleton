package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationIV (

    @SerialName("diamond-pearl"        ) var diamondPearl        : DiamondPearl?        = DiamondPearl(),
    @SerialName("heartgold-soulsilver" ) var heartgoldSoulsilver : HeartgoldSoulsilver? = HeartgoldSoulsilver(),
    @SerialName("platinum"             ) var platinum             : Platinum?             = Platinum()

)