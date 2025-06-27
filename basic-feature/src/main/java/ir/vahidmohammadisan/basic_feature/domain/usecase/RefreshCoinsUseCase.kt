package ir.vahidmohammadisan.basic_feature.domain.usecase

import ir.vahidmohammadisan.basic_feature.domain.repository.CoinRepository
import ir.vahidmohammadisan.core.utils.resultOf

fun interface RefreshCoinsUseCase : suspend () -> Result<Unit>

suspend fun refreshCoins(
    coinRepository: CoinRepository,
): Result<Unit> = resultOf {
    coinRepository.refreshCoins()
}
