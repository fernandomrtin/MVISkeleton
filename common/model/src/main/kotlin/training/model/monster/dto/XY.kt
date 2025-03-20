package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class XY (

  @SerialName("front_default"      ) var frontDefault     : String? = null,
  @SerialName("front_female"       ) var frontFemale      : String? = null,
  @SerialName("front_shiny"        ) var frontShiny       : String? = null,
  @SerialName("front_shiny_female" ) var frontShinyFemale : String? = null

)