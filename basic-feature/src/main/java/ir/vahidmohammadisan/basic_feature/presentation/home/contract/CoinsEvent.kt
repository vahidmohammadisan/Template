package ir.vahidmohammadisan.basic_feature.presentation.home.contract

sealed class CoinsEvent {
    data class OpenWebBrowserWithDetails(val uri: String) : CoinsEvent()
}
