package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Emerald (

  @SerialName("front_default" ) var frontDefault : String? = null,
  @SerialName("front_shiny"   ) var frontShiny   : String? = null

)