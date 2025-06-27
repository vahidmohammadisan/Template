package ir.vahidmohammadisan.basic_feature.presentation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ir.vahidmohammadisan.basic_feature.presentation.CoinsNavigationFactory
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsUiState
import ir.vahidmohammadisan.core.navigation.NavigationFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object CoinsViewModelModule {

    @Provides
    fun provideInitialCoinsUiState(): CoinsUiState = CoinsUiState()
}

@Module
@InstallIn(SingletonComponent::class)
internal interface CoinsSingletonModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindCoinsNavigationFactory(factory: CoinsNavigationFactory): NavigationFactory
}
