package ir.vahidmohammadisan.basic_feature.presentation.mapper

import ir.vahidmohammadisan.basic_feature.domain.model.Coin
import ir.vahidmohammadisan.basic_feature.presentation.model.CoinDisplayable
import java.text.DecimalFormat

private val decimalFormat = DecimalFormat("#,###.##")

fun Coin.toPresentationModel(): CoinDisplayable = CoinDisplayable(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    priceUsd = "$${decimalFormat.format(priceUsd)}",
    percentChange1h = "${decimalFormat.format(percentChange1h)}%",
    percentChange24h = "${decimalFormat.format(percentChange24h)}%",
    percentChange7d = "${decimalFormat.format(percentChange7d)}%",
    marketCapUsd = "$${decimalFormat.format(marketCapUsd)}",
    volume24h = "$${decimalFormat.format(volume24)}",
    circulatingSupply = decimalFormat.format(circulatingSupply),
    maxSupply = maxSupply?.let { decimalFormat.format(it) }
)
