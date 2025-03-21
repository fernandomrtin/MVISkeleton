package training.domain.model


data class MenuData(
    val header: Int?,
    val itemList: List<MenuElement>
)

data class MenuElement(
    val id: MenuOption,
    val titleRes: Int,
    val type: MenuType,
)

sealed class MenuType {
    data object SubMenu: MenuType()
    data class Section(val route: String): MenuType()
    data class ExternalWeb(val link: String): MenuType()
    data class SectionMenu(val route: String): MenuType()
    data class Sheet(val textInformation: String): MenuType()
}

enum class MenuOption {
    HOME
}
