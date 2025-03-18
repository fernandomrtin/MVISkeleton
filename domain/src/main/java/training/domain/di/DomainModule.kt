package training.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import training.domain.bridge.MainBridge
import training.domain.bridge.MainBridgeImpl
import training.domain.contract.MenuRepository
import training.domain.usecase.menu.GetMenuOptionListUseCase

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
    fun provideGetMenuOptionListUseCase(menuRepository: MenuRepository): GetMenuOptionListUseCase {
        return GetMenuOptionListUseCase(menuRepository)
    }

}