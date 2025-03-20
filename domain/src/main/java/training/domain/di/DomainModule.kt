package training.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import training.domain.bridge.MainBridge
import training.domain.bridge.MainBridgeImpl
import training.domain.contract.MenuRepository
import training.domain.contract.MonstersRepository
import training.domain.usecase.menu.GetMenuOptionListUseCase
import training.domain.usecase.monsters.GetMonstersListUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideMainBridge(
        getMenuOptionListUseCase: GetMenuOptionListUseCase,
        getMonstersListUseCase: GetMonstersListUseCase
    ): MainBridge {
        return MainBridgeImpl(
            getMenuOptionListUseCase,
            getMonstersListUseCase
        )
    }

    @Provides
    fun provideGetMenuOptionListUseCase(menuRepository: MenuRepository): GetMenuOptionListUseCase {
        return GetMenuOptionListUseCase(menuRepository)
    }

    @Provides
    fun provideGetMonstersListUseCase(monstersRepository: MonstersRepository): GetMonstersListUseCase {
        return GetMonstersListUseCase(monstersRepository)
    }

}