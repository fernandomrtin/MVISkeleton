package training.ui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import training.model.menu.MenuData
import training.model.menu.MenuElement

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    menuData: MenuData = MenuData(header = null, itemList = emptyList()),
    onMenuItemCLick: (MenuElement) -> Unit = {},
    onBackMenuItemClick: () -> Unit = {},
    onCloseDrawerClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            DrawerContent(
                drawerState = drawerState,
                menuData = menuData,
                onMenuItemClick = onMenuItemCLick,
                onBackMenuItemClick = onBackMenuItemClick,
                onCloseDrawerClick = onCloseDrawerClick
            )
        }
    ) {
        content()
    }
}