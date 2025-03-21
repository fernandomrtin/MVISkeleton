package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Move (

  @SerialName("name" ) var name : String? = null,
  @SerialName("url"  ) var url  : String? = null

)