package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class DreamWorld (

  @SerialName("front_default" ) var frontDefault : String? = null,
  @SerialName("front_female"  ) var frontFemale  : String? = null

)