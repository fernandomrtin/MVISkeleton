package training.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    @DrawableRes navIcon: Int,
    title: String = "RCDMallorca",
    image: Int? = null,
    onIconClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Transparent,
            navigationIconContentColor = Color.Black
        ),
        title = {
            image?.let {
                Image(painterResource(image), contentDescription = "ToolbarImage")
            } ?: run { Text(title) }
        },
        navigationIcon = {
            IconButton(onClick = onIconClick) {
                Icon(
                    painter = painterResource(navIcon),
                    contentDescription = "MenuIcon"
                )
            }
        },
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 24.dp)
            .statusBarsPadding()
            .systemBarsPadding()
    )
}