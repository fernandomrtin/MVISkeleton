package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationI (

    @SerialName("red-blue" ) var redBlue : RedBlue? = RedBlue(),
    @SerialName("yellow"   ) var yellow   : Yellow?   = Yellow()

)