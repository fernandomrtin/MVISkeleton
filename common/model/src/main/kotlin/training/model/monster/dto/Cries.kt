package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Cries (

  @SerialName("latest" ) var latest : String? = null,
  @SerialName("legacy" ) var legacy : String? = null

)