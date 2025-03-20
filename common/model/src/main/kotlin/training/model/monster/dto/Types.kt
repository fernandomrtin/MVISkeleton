package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Types (

  @SerialName("slot" ) var slot : Int?  = null,
  @SerialName("type" ) var type : Type? = Type()

)