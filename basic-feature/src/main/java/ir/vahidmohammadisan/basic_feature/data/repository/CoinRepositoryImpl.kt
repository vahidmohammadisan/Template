package ir.vahidmohammadisan.basic_feature.data.repository

import ir.vahidmohammadisan.basic_feature.data.local.dao.CoinDao
import ir.vahidmohammadisan.basic_feature.data.mapper.toDomainModel
import ir.vahidmohammadisan.basic_feature.data.mapper.toEntityModel
import ir.vahidmohammadisan.basic_feature.data.remote.api.CoinApi
import ir.vahidmohammadisan.basic_feature.domain.model.Coin
import ir.vahidmohammadisan.basic_feature.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi,
    private val coinDao: CoinDao,
) : CoinRepository {

    override fun getCoins(): Flow<List<Coin>> {
        return coinDao
            .getCoins()
            .map { coinsCached ->
                coinsCached.map { it.toDomainModel() }
            }
            .onEach { coins ->
                if (coins.isEmpty()) {
                    refreshCoins()
                }
            }
    }

    override suspend fun refreshCoins() {
        coinApi
            .getCoins().data
            .map {
                it.toDomainModel().toEntityModel()
            }
            .also {
                coinDao.saveCoins(it)
            }
    }
}
