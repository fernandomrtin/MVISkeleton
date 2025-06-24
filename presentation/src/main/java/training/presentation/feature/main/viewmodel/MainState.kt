package training.presentation.feature.main.viewmodel

import training.domain.model.MenuData

data class MainState(
    val isDrawerEnabled: Boolean = true,
    val isDrawerOpen: Boolean = false,
    val menuData: MenuData = MenuData(header = null, itemList = listOf())
)