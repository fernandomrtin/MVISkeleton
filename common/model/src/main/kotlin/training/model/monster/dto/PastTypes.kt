package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class PastTypes (

    @SerialName("generation" ) var generation : Generation?      = Generation(),
    @SerialName("types"      ) var types      : ArrayList<Types> = arrayListOf()

)