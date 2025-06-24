package training.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import training.ui.row.HeaderMenuRow
import training.ui.row.MenuRow
import kotlinx.coroutines.launch
import training.domain.model.MenuData
import training.domain.model.MenuElement
import training.domain.model.MenuOption
import training.domain.model.MenuType
import training.ui.theme.LocalColors

@Composable
fun DrawerContent(
    drawerState: DrawerState,
    menuData: MenuData,
    onMenuItemClick: (MenuElement) -> Unit = {},
    onBackMenuItemClick: () -> Unit = {},
    onCloseDrawerClick: () -> Unit = {}
) {

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.backgroundColor)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Toolbar(
                navIcon = R.drawable.ic_close,
                image = R.drawable.ic_close,
                onIconClick = {
                    scope.launch {
                        if (drawerState.isOpen) {
                            drawerState.close()
                        } else {
                            drawerState.open()
                        }
                    }
                    onCloseDrawerClick()
                }
            )

            Column(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            ) {
                menuData.header?.let { headerRes ->
                    HeaderMenuRow(
                        titleRes = headerRes,
                        modifier = Modifier.clickable {
                            onBackMenuItemClick()
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                menuData.itemList.forEach { item ->
                    MenuRow(
                        titleRes = item.titleRes,
                        hasSubMenu = item.type is MenuType.SubMenu,
                        modifier = Modifier.clickable {
                            onMenuItemClick(item)
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
@Preview
fun DrawerPreview() {
    DrawerContent(
        drawerState = rememberDrawerState(DrawerValue.Open),
        menuData = MenuData(
            header = null, itemList = listOf(
                MenuElement(
                    id = MenuOption.HOME,
                    R.string.test,
                    MenuType.SubMenu
                )
            )
        )
    )
}
