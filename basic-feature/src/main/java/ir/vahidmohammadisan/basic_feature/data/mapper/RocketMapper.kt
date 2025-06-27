package ir.vahidmohammadisan.basic_feature.data.mapper

import ir.vahidmohammadisan.basic_feature.data.local.model.CoinCached
import ir.vahidmohammadisan.basic_feature.data.remote.model.CoinResponse
import ir.vahidmohammadisan.basic_feature.domain.model.Coin

fun CoinResponse.toDomainModel() = Coin(
    id = id,
    symbol = symbol,
    name = name,
    rank = rank,
    priceUsd = priceUsd.toDoubleOrNull() ?: 0.0,
    percentChange1h = percentChange1h.toDoubleOrNull() ?: 0.0,
    percentChange24h = percentChange24h.toDoubleOrNull() ?: 0.0,
    percentChange7d = percentChange7d.toDoubleOrNull() ?: 0.0,
    marketCapUsd = marketCapUsd.toDoubleOrNull() ?: 0.0,
    volume24 = volume24,
    circulatingSupply = circulatingSupply.toDoubleOrNull() ?: 0.0,
    maxSupply = maxSupply?.toDoubleOrNull()
)

fun CoinCached.toDomainModel() = Coin(
    id = id,
    symbol = symbol,
    name = name,
    rank = rank,
    priceUsd = priceUsd,
    percentChange1h = percentChange1h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    marketCapUsd = marketCapUsd,
    volume24 = volume24,
    circulatingSupply = circulatingSupply,
    maxSupply = maxSupply
)

fun Coin.toEntityModel() = CoinCached(
    id = id,
    symbol = symbol,
    name = name,
    rank = rank,
    priceUsd = priceUsd,
    percentChange1h = percentChange1h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    marketCapUsd = marketCapUsd,
    volume24 = volume24,
    circulatingSupply = circulatingSupply,
    maxSupply = maxSupply
)
