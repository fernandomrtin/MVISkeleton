package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationVIII (

  @SerialName("icons" ) var icons : Icons? = Icons()

)