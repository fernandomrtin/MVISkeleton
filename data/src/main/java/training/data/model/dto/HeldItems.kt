package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class HeldItems (

    @SerialName("item"            ) var item           : Item?                     = Item(),
    @SerialName("version_details" ) var versionDetails : ArrayList<VersionDetails> = arrayListOf()

)