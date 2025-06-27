package ir.vahidmohammadisan.basic_feature.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoinCached(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "rank") val rank: Int,
    @ColumnInfo(name = "price_usd") val priceUsd: Double,
    @ColumnInfo(name = "percent_change_1h") val percentChange1h: Double,
    @ColumnInfo(name = "percent_change_24h") val percentChange24h: Double,
    @ColumnInfo(name = "percent_change_7d") val percentChange7d: Double,
    @ColumnInfo(name = "market_cap_usd") val marketCapUsd: Double,
    @ColumnInfo(name = "volume_24h") val volume24: Double,
    @ColumnInfo(name = "circulating_supply") val circulatingSupply: Double,
    @ColumnInfo(name = "max_supply") val maxSupply: Double?
)
