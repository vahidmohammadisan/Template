package ir.vahidmohammadisan.basic_feature.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.vahidmohammadisan.basic_feature.data.remote.api.RocketApi
import ir.vahidmohammadisan.basic_feature.data.repository.RocketRepositoryImpl
import ir.vahidmohammadisan.basic_feature.domain.repository.RocketRepository
import ir.vahidmohammadisan.basic_feature.domain.usecase.GetRocketsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.RefreshRocketsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.getRockets
import ir.vahidmohammadisan.basic_feature.domain.usecase.refreshRockets
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RocketModule {

    @Provides
    @Singleton
    fun provideRocketApi(
        retrofit: Retrofit,
    ): RocketApi {
        return retrofit.create(RocketApi::class.java)
    }

    @Provides
    fun provideGetRocketsUseCase(
        rocketRepository: RocketRepository,
    ): GetRocketsUseCase {
        return GetRocketsUseCase {
            getRockets(rocketRepository)
        }
    }

    @Provides
    fun provideRefreshRocketsUseCase(
        rocketRepository: RocketRepository,
    ): RefreshRocketsUseCase {
        return RefreshRocketsUseCase {
            refreshRockets(rocketRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindRocketRepository(impl: RocketRepositoryImpl): RocketRepository
    }
}
