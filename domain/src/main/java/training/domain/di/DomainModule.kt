package training.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import training.domain.bridge.DetailsBridge
import training.domain.bridge.DetailsBridgeImpl
import training.domain.bridge.HomeBridge
import training.domain.bridge.HomeBridgeImpl
import training.domain.bridge.MainBridge
import training.domain.bridge.MainBridgeImpl
import training.domain.contract.MenuRepository
import training.domain.contract.MonstersRepository
import training.domain.usecase.menu.GetMenuOptionListUseCase
import training.domain.usecase.monsters.GetMonsterFromIdUseCase
import training.domain.usecase.monsters.GetMonstersListUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideMainBridge(
        getMenuOptionListUseCase: GetMenuOptionListUseCase
    ): MainBridge {
        return MainBridgeImpl(
            getMenuOptionListUseCase
        )
    }

    @Provides
    fun provideHomeBridge(
        getMonstersListUseCase: GetMonstersListUseCase
    ): HomeBridge {
        return HomeBridgeImpl(
            getMonstersListUseCase
        )
    }

    @Provides
    fun provideDetailsBridge(
        getMonsterFromIdUseCase: GetMonsterFromIdUseCase
    ): DetailsBridge {
        return DetailsBridgeImpl(
            getMonsterFromIdUseCase
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

    @Provides
    fun provideGetMonsterFromIdUseCase(monstersRepository: MonstersRepository): GetMonsterFromIdUseCase {
        return GetMonsterFromIdUseCase(monstersRepository)
    }

}