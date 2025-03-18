package training.data.di

import training.network.di.TokenProvider
import training.data.TokenManager
import training.data.datasource.MenuDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideTokenProvider(tokenManager: TokenManager): TokenProvider {
        return tokenManager
    }

    @Provides
    @Singleton
    fun provideMenuDataSource(): MenuDatasource {
        return MenuDatasource()
    }
}