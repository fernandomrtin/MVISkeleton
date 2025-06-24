package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class VersionDetails (

  @SerialName("rarity"  ) var rarity  : Int?     = null,
  @SerialName("version" ) var version : Version? = Version()

)