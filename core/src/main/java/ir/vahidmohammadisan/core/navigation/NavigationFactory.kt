package ir.vahidmohammadisan.core.navigation

import androidx.navigation.NavGraphBuilder

interface NavigationFactory {
    fun create(builder: NavGraphBuilder)
}
