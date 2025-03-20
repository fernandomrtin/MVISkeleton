package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class RedBlue (

  @SerialName("back_default"  ) var backDefault  : String? = null,
  @SerialName("back_gray"     ) var backGray     : String? = null,
  @SerialName("front_default" ) var frontDefault : String? = null,
  @SerialName("front_gray"    ) var frontGray    : String? = null

)