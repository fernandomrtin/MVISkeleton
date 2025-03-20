package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Other (

    @SerialName("dream_world"      ) var dreamWorld       : DreamWorld?       = DreamWorld(),
    @SerialName("home"             ) var home             : Home?             = Home(),
    @SerialName("official-artwork" ) var officialArtwork : OfficialArtwork? = OfficialArtwork(),
    @SerialName("showdown"         ) var showdown         : Showdown?         = Showdown()

)