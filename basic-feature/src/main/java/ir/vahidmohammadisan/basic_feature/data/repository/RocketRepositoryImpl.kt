package ir.vahidmohammadisan.basic_feature.data.repository

import ir.vahidmohammadisan.basic_feature.data.local.dao.RocketDao
import ir.vahidmohammadisan.basic_feature.data.mapper.toDomainModel
import ir.vahidmohammadisan.basic_feature.data.mapper.toEntityModel
import ir.vahidmohammadisan.basic_feature.data.remote.api.RocketApi
import ir.vahidmohammadisan.basic_feature.domain.model.Rocket
import ir.vahidmohammadisan.basic_feature.domain.repository.RocketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class RocketRepositoryImpl @Inject constructor(
    private val rocketApi: RocketApi,
    private val rocketDao: RocketDao,
) : RocketRepository {

    override fun getRockets(): Flow<List<Rocket>> {
        return rocketDao
            .getRockets()
            .map { rocketsCached ->
                rocketsCached.map { it.toDomainModel() }
            }
            .onEach { rockets ->
                if (rockets.isEmpty()) {
                    refreshRockets()
                }
            }
    }

    override suspend fun refreshRockets() {
        rocketApi
            .getRockets()
            .map {
                it.toDomainModel().toEntityModel()
            }
            .also {
                rocketDao.saveRockets(it)
            }
    }
}
