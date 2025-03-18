package training.ui.row

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import training.ui.R
import training.ui.theme.LocalColors

@Composable
fun MenuRow(
    @StringRes titleRes: Int,
    hasSubMenu: Boolean,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = stringResource(titleRes).uppercase(),
            fontSize = 32.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = LocalColors.current.fontColor
        )

        if (hasSubMenu) {
            Image(
                painter = painterResource(R.drawable.ic_chevron_next),
                contentDescription = "MenuNext",
            )
        }
    }
}

@Composable
@Preview
fun MenuRowPreview() {
    MenuRow(R.string.test, true, Modifier)
}