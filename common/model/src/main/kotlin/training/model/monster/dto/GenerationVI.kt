package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationVI (

    @SerialName("omegaruby-alphasapphire" ) var omegarubyAlphasapphire : OmegarubyAlphasapphire? = OmegarubyAlphasapphire(),
    @SerialName("x-y"                     ) var xY                     : XY?                     = XY()

)