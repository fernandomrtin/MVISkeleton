package training.presentation.feature.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import training.presentation.feature.home.viewmodel.HomeViewModel
import training.ui.row.MonsterRow

@Composable
fun HomeScreen(onNavigateToDetails: (Int) -> Unit, viewModel: HomeViewModel = hiltViewModel()) {
    val homeState by viewModel.homeState.collectAsState()

    Column {
        Text(
            text = "Monsters",
            fontSize = 32.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.DarkGray,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            items(homeState.monstersList) {
                MonsterRow(name = it.name.orEmpty(), imageUrl = it.imageUrl, modifier = Modifier.clickable {
                    onNavigateToDetails(it.id)
                })
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(onNavigateToDetails = {})
}