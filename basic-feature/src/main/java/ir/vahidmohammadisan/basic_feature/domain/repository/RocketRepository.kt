package ir.vahidmohammadisan.basic_feature.domain.repository

import ir.vahidmohammadisan.basic_feature.domain.model.Rocket
import kotlinx.coroutines.flow.Flow

interface RocketRepository {
    fun getRockets(): Flow<List<Rocket>>
    suspend fun refreshRockets()
}
