package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Stats (

  @SerialName("base_stat" ) var baseStat : Int?  = null,
  @SerialName("effort"    ) var effort   : Int?  = null,
  @SerialName("stat"      ) var stat     : Stat? = Stat()

)