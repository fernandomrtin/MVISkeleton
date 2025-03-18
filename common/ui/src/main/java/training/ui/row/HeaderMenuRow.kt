package training.ui.row

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import training.ui.R

@Composable
fun HeaderMenuRow(
    @StringRes titleRes: Int,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {

        Image(
            painter = painterResource(R.drawable.ic_close),
            contentDescription = "MenuNext",
            modifier = Modifier.rotate(180f),
            colorFilter = ColorFilter.tint(Color.Black)
        )

        Text(
            text = stringResource(titleRes).uppercase(),
            fontSize = 32.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Black
        )
    }
}

@Composable
@Preview
fun HeaderMenuRowPreview() {
    HeaderMenuRow(R.string.test, Modifier)
}