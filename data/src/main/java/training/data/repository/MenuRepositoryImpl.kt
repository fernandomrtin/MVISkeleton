package training.data.repository

import training.data.datasource.local.MenuLocalDatasource
import training.domain.contract.MenuRepository
import training.domain.model.MenuOption
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val menuLocalDatasource: MenuLocalDatasource
): MenuRepository {

    override fun getMainMenuOptionList() =
        menuLocalDatasource.getMainMenuOptionList()

    override fun getSubMenuByOption(menuOption: MenuOption) =
        menuLocalDatasource.getSubMenuByOption(menuOption)
}