package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class RubySapphire (

  @SerialName("back_default"  ) var backDefault  : String? = null,
  @SerialName("back_shiny"    ) var backShiny    : String? = null,
  @SerialName("front_default" ) var frontDefault : String? = null,
  @SerialName("front_shiny"   ) var frontShiny   : String? = null

)