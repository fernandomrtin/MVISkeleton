package training.data.repository

import training.data.datasource.MenuDatasource
import training.domain.contract.MenuRepository
import training.model.menu.MenuOption
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val menuDatasource: MenuDatasource
): MenuRepository {

    override fun getMainMenuOptionList() =
        menuDatasource.getMainMenuOptionList()

    override fun getSubMenuByOption(menuOption: MenuOption) =
        menuDatasource.getSubMenuByOption(menuOption)
}