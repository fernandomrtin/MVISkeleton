package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GameIndices (

  @SerialName("game_index" ) var gameIndex : Int?     = null,
  @SerialName("version"    ) var version   : Version? = Version()

)