package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Item (

  @SerialName("name" ) var name : String? = null,
  @SerialName("url"  ) var url  : String? = null

)