package training.presentation.feature.main.viewmodel

import training.domain.model.MenuElement

sealed class MainIntent {
    data class ToggleDrawerVisibility(val isVisible: Boolean) : MainIntent()
    data object OpenDrawer : MainIntent()
    data object CloseDrawer : MainIntent()
    data class SelectMenuElement(val element: MenuElement) : MainIntent()
    data object NavigateBackSubMenu : MainIntent()
    data object NavigationItemClick : MainIntent()
}