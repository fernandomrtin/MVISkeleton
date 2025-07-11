package training.ui.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import training.ui.RemoteImage
import training.ui.theme.LocalColors

@Composable
fun MonsterRow(
    name: String,
    imageUrl: String?,
    modifier: Modifier
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name.replaceFirstChar { it.uppercaseChar() },
                fontSize = 32.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = LocalColors.current.fontColor
            )
            val defaultUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
            RemoteImage(url = imageUrl ?: defaultUrl, description = "monsterImage")
        }
    }
}

@Composable
@Preview
fun MonsterRowPreview() {
    MonsterRow(
        name = "Pikachu",
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
        Modifier
    )
}