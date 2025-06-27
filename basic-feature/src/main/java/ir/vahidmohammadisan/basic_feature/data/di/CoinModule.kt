package ir.vahidmohammadisan.basic_feature.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.vahidmohammadisan.basic_feature.data.remote.api.CoinApi
import ir.vahidmohammadisan.basic_feature.data.repository.CoinRepositoryImpl
import ir.vahidmohammadisan.basic_feature.domain.repository.CoinRepository
import ir.vahidmohammadisan.basic_feature.domain.usecase.GetCoinsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.RefreshCoinsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.getCoins
import ir.vahidmohammadisan.basic_feature.domain.usecase.refreshCoins
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoinModule {

    @Provides
    @Singleton
    fun provideCoinApi(
        retrofit: Retrofit,
    ): CoinApi {
        return retrofit.create(CoinApi::class.java)
    }

    @Provides
    fun provideGetCoinsUseCase(
        coinRepository: CoinRepository,
    ): GetCoinsUseCase {
        return GetCoinsUseCase {
            getCoins(coinRepository)
        }
    }

    @Provides
    fun provideRefreshCoinsUseCase(
        coinRepository: CoinRepository,
    ): RefreshCoinsUseCase {
        return RefreshCoinsUseCase {
            refreshCoins(coinRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository
    }
}
