package ir.vahidmohammadisan.basic_feature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponse(
    @SerialName("id") val id: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("name") val name: String,
    @SerialName("rank") val rank: Int,
    @SerialName("price_usd") val priceUsd: String,
    @SerialName("percent_change_1h") val percentChange1h: String,
    @SerialName("percent_change_24h") val percentChange24h: String,
    @SerialName("percent_change_7d") val percentChange7d: String,
    @SerialName("market_cap_usd") val marketCapUsd: String,
    @SerialName("volume24") val volume24: Double,
    @SerialName("csupply") val circulatingSupply: String,
    @SerialName("msupply") val maxSupply: String?
)


@Serializable
data class CoinListResponse(
    @SerialName("data") val data: List<CoinResponse>
)
