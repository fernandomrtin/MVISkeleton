package training.model.monster.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class GenerationIII (

    @SerialName("emerald"           ) var emerald           : Emerald?           = Emerald(),
    @SerialName("firered-leafgreen" ) var fireredLeafgreen : FireredLeafgreen? = FireredLeafgreen(),
    @SerialName("ruby-sapphire"     ) var rubySapphire     : RubySapphire?     = RubySapphire()

)