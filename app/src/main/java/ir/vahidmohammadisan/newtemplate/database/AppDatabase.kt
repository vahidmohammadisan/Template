package ir.vahidmohammadisan.newtemplate.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.vahidmohammadisan.basic_feature.data.local.dao.CoinDao
import ir.vahidmohammadisan.basic_feature.data.local.model.CoinCached


private const val DATABASE_VERSION = 1

@Database(
    entities = [CoinCached::class],
    version = DATABASE_VERSION,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}
