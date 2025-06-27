package ir.vahidmohammadisan.basic_feature.domain.repository

import ir.vahidmohammadisan.basic_feature.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCoins(): Flow<List<Coin>>
    suspend fun refreshCoins()
}
