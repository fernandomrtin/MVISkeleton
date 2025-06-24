package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationV (

  @SerialName("blackWhite" ) var blackWhite : BlackWhite? = BlackWhite()

)