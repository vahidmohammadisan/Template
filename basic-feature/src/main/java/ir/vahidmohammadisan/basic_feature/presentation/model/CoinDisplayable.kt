package ir.vahidmohammadisan.basic_feature.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinDisplayable(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: String,
    val percentChange1h: String,
    val percentChange24h: String,
    val percentChange7d: String,
    val marketCapUsd: String,
    val volume24h: String,
    val circulatingSupply: String,
    val maxSupply: String?
) : Parcelable
