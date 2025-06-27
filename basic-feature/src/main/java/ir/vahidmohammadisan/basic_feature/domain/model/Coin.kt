package ir.vahidmohammadisan.basic_feature.domain.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val rank: Int,
    val priceUsd: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val marketCapUsd: Double,
    val volume24: Double,
    val circulatingSupply: Double,
    val maxSupply: Double?
)
