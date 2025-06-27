package ir.vahidmohammadisan.basic_feature.presentation.home.contract

sealed class CoinsIntent {
    data object RefreshCoins : CoinsIntent()
    data class CoinClicked(val id: String) : CoinsIntent()
}
