package training.data.model.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Versions (

    @SerialName("generation-i"    ) var generationI    : GenerationI?    = GenerationI(),
    @SerialName("generation-ii"   ) var generationII   : GenerationII?   = GenerationII(),
    @SerialName("generation-iii"  ) var generationIII  : GenerationIII?  = GenerationIII(),
    @SerialName("generation-iv"   ) var generationIV   : GenerationIV?   = GenerationIV(),
    @SerialName("generation-v"    ) var generationV    : GenerationV?    = GenerationV(),
    @SerialName("generation-vi"   ) var generationVI   : GenerationVI?   = GenerationVI(),
    @SerialName("generation-vii"  ) var generationVII  : GenerationVII?  = GenerationVII(),
    @SerialName("generation-viii" ) var generationVIII : GenerationVIII? = GenerationVIII()

)