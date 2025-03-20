package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Moves (

    @SerialName("move"                  ) var move                : Move?                          = Move(),
    @SerialName("version_group_details" ) var versionGroupDetails : ArrayList<VersionGroupDetails> = arrayListOf()

)