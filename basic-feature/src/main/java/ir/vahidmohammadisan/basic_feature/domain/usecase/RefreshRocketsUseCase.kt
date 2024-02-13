package ir.vahidmohammadisan.basic_feature.domain.usecase

import ir.vahidmohammadisan.basic_feature.domain.repository.RocketRepository
import ir.vahidmohammadisan.core.utils.resultOf

fun interface RefreshRocketsUseCase : suspend () -> Result<Unit>

suspend fun refreshRockets(
    rocketRepository: RocketRepository,
): Result<Unit> = resultOf {
    rocketRepository.refreshRockets()
}
