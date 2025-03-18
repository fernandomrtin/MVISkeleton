package training.presentation.feature.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import training.ui.Toolbar

@Composable
fun DetailsScreen(userId: Int?, onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            Toolbar(
                navIcon = training.ui.R.drawable.ic_close,
                onIconClick = {
                    onBackPressed.invoke()
                })
        },
        containerColor = Color.Black,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(text = "Detalles del Usuario ID: ${userId ?: "Desconocido"}",
                color = Color.White)
        }
    }

}