package ir.vahidmohammadisan.basic_feature.presentation

sealed class RocketsEvent {
    data class OpenWebBrowserWithDetails(val uri: String) : RocketsEvent()
}
