package training.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RemoteImage(
    url: String,
    description: String?,
    modifier: Modifier = Modifier
) {
    GlideImage(
        model = url,
        contentDescription = description,
        modifier = modifier
    )
}