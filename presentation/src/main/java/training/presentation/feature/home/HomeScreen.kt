package training.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(onNavigateToDetails: (Int) -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Text(
            text = "Usuario: Juan",
            modifier = Modifier
                .clickable { onNavigateToDetails(1) },
            color = Color.White
        )
        Text(
            text = "Usuario: Ana",
            modifier = Modifier
                .clickable { onNavigateToDetails(2) },
            color = Color.White
        )
    }
}