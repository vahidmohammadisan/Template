package ir.vahidmohammadisan.basic_feature.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.vahidmohammadisan.basic_feature.presentation.composable.CoinsRoute
import ir.vahidmohammadisan.core.navigation.NavigationDestination
import ir.vahidmohammadisan.core.navigation.NavigationFactory
import javax.inject.Inject

class CoinsNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(NavigationDestination.Coins.route) {
            CoinsRoute()
        }
    }
}
