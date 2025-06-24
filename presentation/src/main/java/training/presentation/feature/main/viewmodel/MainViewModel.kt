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
import training.domain.model.MenuData
import training.domain.model.MenuElement
import training.domain.model.MenuType
import training.presentation.feature.main.toMenuElementList
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainBridge: MainBridge
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    private val stackMenuList: MutableList<MenuData> = mutableListOf()

    private fun getMenuOptionList(menuElement: MenuElement? = null) {
        viewModelScope.launch {
            mainBridge.getMenuListByOption(menuElement?.id).fold(
                ifLeft = {},
                ifRight = { menuOptionList ->
                    _mainState.update { mainState ->
                        mainState.copy(
                            isDrawerOpen = true,
                            menuData = MenuData(
                                header = menuElement?.titleRes,
                                itemList = menuOptionList.toMenuElementList()
                            )
                        )
                    }
                }
            )
        }
    }

    fun onIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.ToggleDrawerVisibility -> {
                changeDrawerStatus(isEnabled = intent.isVisible)
            }

            MainIntent.OpenDrawer -> {
                openDrawer()
            }

            MainIntent.CloseDrawer -> {
                closeDrawer()
            }

            is MainIntent.SelectMenuElement -> {
                menuElementClick(intent.element)
            }

            MainIntent.NavigateBackSubMenu -> {
                backSubMenuClick()
            }

            MainIntent.NavigationItemClick -> {
                getMenuOptionList()
            }
        }
    }

    private fun changeDrawerStatus(isEnabled: Boolean) {
        _mainState.update { mainState ->
            mainState.copy(isDrawerEnabled = isEnabled)
        }
    }

    private fun openDrawer() {
        _mainState.update { mainState ->
            mainState.copy(isDrawerOpen = true)
        }
    }

    private fun closeDrawer() {
        _mainState.update { mainState ->
            mainState.copy(isDrawerOpen = false)
        }
    }

    private fun menuElementClick(menuElement: MenuElement) {
        when (menuElement.type) {
            is MenuType.Section -> closeDrawer()
            is MenuType.SubMenu -> {
                stackMenuList.add(mainState.value.menuData)
                getMenuOptionList(menuElement)
            }

            else -> closeDrawer()
        }
    }

    private fun backSubMenuClick() {
        _mainState.update { mainState ->
            mainState.copy(menuData = stackMenuList.last())
        }
        stackMenuList.removeAt(stackMenuList.size - 1)
    }
}
