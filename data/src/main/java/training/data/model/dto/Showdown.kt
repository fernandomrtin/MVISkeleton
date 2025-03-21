package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Showdown (

  @SerialName("back_default"       ) var backDefault      : String? = null,
  @SerialName("back_female"        ) var backFemale       : String? = null,
  @SerialName("back_shiny"         ) var backShiny        : String? = null,
  @SerialName("back_shiny_female"  ) var backShinyFemale  : String? = null,
  @SerialName("front_default"      ) var frontDefault     : String? = null,
  @SerialName("front_female"       ) var frontFemale      : String? = null,
  @SerialName("front_shiny"        ) var frontShiny       : String? = null,
  @SerialName("front_shiny_female" ) var frontShinyFemale : String? = null

)