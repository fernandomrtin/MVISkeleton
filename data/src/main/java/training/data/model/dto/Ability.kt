package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Ability (

  @SerialName("name" ) var name : String? = null,
  @SerialName("url"  ) var url  : String? = null

)