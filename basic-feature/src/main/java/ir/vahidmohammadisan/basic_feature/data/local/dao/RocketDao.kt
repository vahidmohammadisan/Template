package ir.vahidmohammadisan.basic_feature.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ir.vahidmohammadisan.basic_feature.data.local.model.RocketCached
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDao {

    @Query("SELECT * FROM RocketCached")
    fun getRockets(): Flow<List<RocketCached>>

    @Upsert
    suspend fun saveRockets(rockets: List<RocketCached>)
}
