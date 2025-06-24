package training.data.di

import android.content.Context
import androidx.room.Room
import training.network.di.TokenProvider
import training.data.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import training.data.datasource.local.database.MonsterDao
import training.data.datasource.local.database.MonsterDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MonsterDatabase {
        return Room.databaseBuilder(
            context,
            MonsterDatabase::class.java,
            "monsters_db"
        ).build()
    }

    @Provides
    fun provideMonsterDao(db: MonsterDatabase): MonsterDao {
        return db.monsterDao()
    }

    @Provides
    @Singleton
    fun provideTokenProvider(tokenManager: TokenManager): TokenProvider {
        return tokenManager
    }
}