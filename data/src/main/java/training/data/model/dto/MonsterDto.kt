package training.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MonsterDto (

    @SerialName("id"                       ) var id                     : Int?                   = null,
    @SerialName("name"                     ) var name                   : String?                = null,
    @SerialName("base_experience"          ) var baseExperience         : Int?                   = null,
    @SerialName("height"                   ) var height                 : Int?                   = null,
    @SerialName("is_default"               ) var isDefault              : Boolean?               = null,
    @SerialName("order"                    ) var order                  : Int?                   = null,
    @SerialName("weight"                   ) var weight                 : Int?                   = null,
    @SerialName("abilities"                ) var abilities              : ArrayList<Abilities>   = arrayListOf(),
    @SerialName("forms"                    ) var forms                  : ArrayList<Forms>       = arrayListOf(),
    @SerialName("game_indices"             ) var gameIndices            : ArrayList<GameIndices> = arrayListOf(),
    @SerialName("held_items"               ) var heldItems              : ArrayList<HeldItems>   = arrayListOf(),
    @SerialName("location_area_encounters" ) var locationAreaEncounters : String?                = null,
    @SerialName("moves"                    ) var moves                  : ArrayList<Moves>       = arrayListOf(),
    @SerialName("species"                  ) var species                : Species?               = Species(),
    @SerialName("sprites"                  ) var sprites                : Sprites?               = Sprites(),
    @SerialName("cries"                    ) var cries                  : Cries?                 = Cries(),
    @SerialName("stats"                    ) var stats                  : ArrayList<Stats>       = arrayListOf(),
    @SerialName("types"                    ) var types                  : ArrayList<Types>       = arrayListOf(),
    @SerialName("past_types"               ) var pastTypes              : ArrayList<PastTypes>   = arrayListOf()

)