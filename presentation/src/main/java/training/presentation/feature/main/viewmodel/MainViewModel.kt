package training.presentation.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import training.domain.bridge.MainBridge
import training.model.menu.MenuData
import training.model.menu.MenuElement
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainBridge: MainBridge
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    private val stackMenuList: MutableList<MenuData> = mutableListOf()

    init {
        viewModelScope.launch {
//            mainBridge.getUserData().fold(
//                ifLeft = {},
//                ifRight = { userType ->
//                    _mainState.update { mainState ->
//                        mainState.copy(userType = userType)
//                    }
//                }
//            )
        }

    }

    fun onNavigationItemClick() {
        getMenuOptionList()
    }

    private fun getMenuOptionList(menuElement: MenuElement? = null) {
        viewModelScope.launch {
//            mainBridge.getMenuListByOption(menuElement?.id).fold(
//                ifLeft = {},
//                ifRight = { menuOptionList ->
//                    _mainState.update { mainState ->
//                        mainState.copy(
//                            isDrawerOpen = true,
//                            menuData = MenuData(
//                                header = menuItem?.titleRes,
//                                itemList = menuOptionList.toMenuItemList(),
//                                sawBackground = menuItem == null
//                            )
//                        )
//                    }
//                }
//            )
        }
    }

    fun onMenuItemClick(menuElement: MenuElement) {
//        when (menuItem.type) {
//            is MenuType.Section -> closeDrawer()
//            is MenuType.SubMenu -> {
//                stackMenuList.add(mainState.value.menuData)
//                getMenuOptionList(menuItem)
//            }
//
//            else -> closeDrawer()
//        }
    }

    fun onCloseDrawerClick() {
        closeDrawer()
    }

    fun onChangeDrawerVisibility(visibility: Boolean) {
        _mainState.update { mainState ->
            mainState.copy(enableDrawer = visibility)
        }
    }

    fun onBackSubMenuClick() {
        _mainState.update { mainState ->
            mainState.copy(menuData = stackMenuList.last())
        }
        stackMenuList.removeAt(stackMenuList.size - 1)
    }

    private fun closeDrawer() {
        _mainState.update { mainState ->
            mainState.copy(isDrawerOpen = false)
        }
    }
}
