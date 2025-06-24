package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationVII (

    @SerialName("icons"                ) var icons                : Icons?                = Icons(),
    @SerialName("ultra-sun-ultra-moon" ) var ultraSunUltraMoon : UltraSunUltraMoon? = UltraSunUltraMoon()

)