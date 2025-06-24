package training.data.di

import training.data.repository.MenuRepositoryImpl
import training.domain.contract.MenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import training.data.repository.MonstersRepositoryImpl
import training.domain.contract.MonstersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsMenuRepository(menuRepositoryImpl: MenuRepositoryImpl): MenuRepository

    @Binds
    @Singleton
    abstract fun bindsMonstersRepository(monstersRepositoryImpl: MonstersRepositoryImpl): MonstersRepository

}