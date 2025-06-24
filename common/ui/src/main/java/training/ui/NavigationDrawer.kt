package training.ui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import training.domain.model.MenuData
import training.domain.model.MenuElement

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    menuData: MenuData = MenuData(
        header = null,
        itemList = emptyList()
    ),
    onMenuElementClick: (MenuElement) -> Unit = {},
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
                onMenuItemClick = onMenuElementClick,
                onBackMenuItemClick = onBackMenuItemClick,
                onCloseDrawerClick = onCloseDrawerClick
            )
        }
    ) {
        content()
    }
}