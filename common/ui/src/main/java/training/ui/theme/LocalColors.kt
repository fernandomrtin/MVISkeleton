package training.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class MainColors(
    val backgroundColor: Color = Maroon,
    val decorationColor: Color = WhiteAntiFlash,
    val fontColor: Color = WhiteAntiFlash
)

val LocalColors = compositionLocalOf { MainColors() }

fun getLocalColorsByUserType() = MainColors(backgroundColor = Golden)