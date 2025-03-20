package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Abilities (

  @SerialName("is_hidden" ) var isHidden : Boolean? = null,
  @SerialName("slot"      ) var slot     : Int?     = null,
  @SerialName("ability"   ) var ability  : Ability? = Ability()

)